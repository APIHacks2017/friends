package com.friendsSuggestor.api;

import java.io.File;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class UploadImageToS3Service {
	public  String COLLECTION_ID = "friendsCollection";
	public  String S3_BUCKET = "friends-suggestor-using-image";
	BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJNS4VGBP7BSBQUPQ",
			"wrP7i2VUdgVGtDIPpIG9JptaKLaNvPzQJfmu3cfS");

	public void uploadImageToS3(String fileName){
		 try {
			 AmazonS3 s3client = new AmazonS3Client(new AWSStaticCredentialsProvider(credentials));
		 
	            System.out.println("Uploading a new object to S3 from a file\n");
	            File file = new File(fileName);
	            s3client.putObject(new PutObjectRequest(
	            		S3_BUCKET, fileName, file));

	         } catch (Exception e) {
	        	 
	         }
	}
}
