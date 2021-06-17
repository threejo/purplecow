package com.purplecow.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.purplecow.dto.S3Component;

@Service
public class S3Service {

	 @Autowired private AmazonS3Client amazonS3Client;
	 @Autowired private S3Component s3Component;

	//파일,objectMetadata, unique한 파일이름 가지고 AccessControlList에서 publicRead권한으로 S3버킷에 put
	public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
		amazonS3Client.putObject(new PutObjectRequest(s3Component.getBucket(), fileName, inputStream, objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));

	}
	//S3 버킷정보와 파일이름을 전달해서 파일url 받기
	public String getFileUrl(String fileName) {
		return String.valueOf(amazonS3Client.getUrl(s3Component.getBucket(), fileName));
	}

}
