package com.friendsSuggestor.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.FaceMatch;
import com.amazonaws.services.rekognition.model.SearchFacesRequest;
import com.amazonaws.services.rekognition.model.SearchFacesResult;

@Service
public class SearchFaceByFaceId {
	public  String COLLECTION_ID = "friendsCollection";
	public  String S3_BUCKET = "friends-suggestor-using-image";
	BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJNS4VGBP7BSBQUPQ",
			"wrP7i2VUdgVGtDIPpIG9JptaKLaNvPzQJfmu3cfS");

	public boolean searchFaceByFaceId(String faceId,String groupImageName) {
		Float threshold = 70F;
		int maxFaces = 2;
		AmazonRekognition amazonRekognition = AmazonRekognitionClientBuilder.standard().withRegion(Regions.US_WEST_2)
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

		// 3. Search similar faces for a give face (identified by face ID).
		System.out.println("Faces matching FaceId: " + faceId);
		SearchFacesResult searchFacesResult = callSearchFaces(COLLECTION_ID, faceId, threshold, maxFaces,
				amazonRekognition,groupImageName);
		List<FaceMatch> faceMatches = searchFacesResult.getFaceMatches();
		for (FaceMatch face : faceMatches) {
			System.out.println(face.getFace().toString());
			System.out.println();
		}
		if(faceMatches!=null && faceMatches.size()>0){
			return true;
		}
		return false;
		

	}

	private  SearchFacesResult callSearchFaces(String collectionId, String faceId, Float threshold, int maxFaces,
			AmazonRekognition amazonRekognition, String imageName) {
		SearchFacesRequest searchFacesRequest = new SearchFacesRequest().withCollectionId(collectionId)
				.withFaceId(faceId).withFaceMatchThreshold(threshold).withMaxFaces(maxFaces);
		return amazonRekognition.searchFaces(searchFacesRequest);
	}

}
