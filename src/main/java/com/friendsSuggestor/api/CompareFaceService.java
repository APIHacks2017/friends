package com.friendsSuggestor.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.BoundingBox;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.ComparedFace;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.util.IOUtils;

@Service
public class CompareFaceService {
	public  String COLLECTION_ID = "friendsCollection";
	public  String S3_BUCKET = "friends-suggestor-using-image";
	BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJNS4VGBP7BSBQUPQ",
			"wrP7i2VUdgVGtDIPpIG9JptaKLaNvPzQJfmu3cfS");
	Float similarityThreshold = 70F;

	public List<ComparedFace> compareFaces(String sourceImage,String targetImage,String faceId) {
		try {
		
			ByteBuffer sourceImageBytes = null;
			ByteBuffer targetImageBytes = null;

			AWSCredentials credentials;
			try {
				credentials = new ProfileCredentialsProvider("AdminUser").getCredentials();
			} catch (Exception e) {
				throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
						+ "Please make sure that your credentials file is at the correct "
						+ "location (/Users/userid/.aws/credentials), and is in valid format.", e);
			}

			EndpointConfiguration endpoint = new EndpointConfiguration("endpoint", "us-east-1");

			AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard()
					.withEndpointConfiguration(endpoint).withCredentials(new AWSStaticCredentialsProvider(credentials))
					.build();

			// Load source and target images and create input parameters
			try (InputStream inputStream = new FileInputStream(new File(sourceImage))) {
				sourceImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
			} catch (Exception e) {
				System.out.println("Failed to load source image " + sourceImage);
				System.exit(1);
			}
			try (InputStream inputStream = new FileInputStream(new File(targetImage))) {
				targetImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
			} catch (Exception e) {
				System.out.println("Failed to load target images: " + targetImage);
				System.exit(1);
			}

			Image source = new Image().withBytes(sourceImageBytes);
			Image target = new Image().withBytes(targetImageBytes);

			CompareFacesRequest request = new CompareFacesRequest().withSourceImage(source).withTargetImage(target)
					.withSimilarityThreshold(similarityThreshold);

			// Call operation
			CompareFacesResult compareFacesResult = rekognitionClient.compareFaces(request);

			// Display results
			List<CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
			for (CompareFacesMatch match : faceDetails) {
				ComparedFace face = match.getFace();
				BoundingBox position = face.getBoundingBox();
				System.out.println("Face at " + position.getLeft().toString() + " " + position.getTop()
						+ " matches with " + face.getConfidence().toString() + "% confidence.");

			}
			List<ComparedFace> listunMatched = compareFacesResult.getUnmatchedFaces();

			System.out.println("There were " + listunMatched.size() + " that did not match");
			System.out.println("Source image rotation: " + compareFacesResult.getSourceImageOrientationCorrection());
			System.out.println("target image rotation: " + compareFacesResult.getTargetImageOrientationCorrection());
			
			
			return listunMatched;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
