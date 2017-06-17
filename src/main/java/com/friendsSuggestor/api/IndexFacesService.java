package com.friendsSuggestor.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.FaceRecord;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.IndexFacesRequest;
import com.amazonaws.services.rekognition.model.IndexFacesResult;
import com.amazonaws.services.rekognition.model.S3Object;
import com.friendsSuggestor.model.ImageModel;

@Service
public class IndexFacesService {
	public String COLLECTION_ID = "friendsCollection";
	public  String S3_BUCKET = "friends-suggestor-using-image";
	BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJNS4VGBP7BSBQUPQ",
			"wrP7i2VUdgVGtDIPpIG9JptaKLaNvPzQJfmu3cfS");

	public ImageModel indexImages(String imageName) {
		

		AmazonRekognition amazonRekognition = AmazonRekognitionClientBuilder.standard().withRegion(Regions.US_WEST_2)
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

		// 1. Index face 1
		Image image = getImageUtil(S3_BUCKET, imageName);
		String externalImageId = imageName;
		IndexFacesResult indexFacesResult = callIndexFaces(COLLECTION_ID, externalImageId, "ALL", image,
				amazonRekognition);
		System.out.println(externalImageId + " added");
		List<FaceRecord> faceRecords = indexFacesResult.getFaceRecords();
		String faceId=faceRecords.get(0).getFace().getFaceId();
		System.out.println("Face detected: Faceid is " + faceRecords.get(0).getFace().getFaceId());
		ImageModel imageModel=new ImageModel();
		imageModel.setExternalImageId(imageName);
		imageModel.setFaceId(faceId);
		return imageModel;
	
	}

	private IndexFacesResult callIndexFaces(String collectionId, String externalImageId, String attributes,
			Image image, AmazonRekognition amazonRekognition) {
		IndexFacesRequest indexFacesRequest = new IndexFacesRequest().withImage(image).withCollectionId(collectionId)
				.withExternalImageId(externalImageId).withDetectionAttributes(attributes);
		return amazonRekognition.indexFaces(indexFacesRequest);

	}

	private Image getImageUtil(String bucket, String key) {
		return new Image().withS3Object(new S3Object().withBucket(bucket).withName(key));
	}

}
