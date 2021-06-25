package com.purplecow.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class FileService {

	@Autowired S3Service s3Service;

	//이미지 업로드
	public String uploadImage(MultipartFile file) {
		//원래 파일이름을 unique하게 바꿔서 fileName에 저장
		String fileName = createFileName(file.getOriginalFilename());
		//ObjectMetadat객체를 원래 파일의 content type으로 설정
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        //s3service에 파일, objectmetadata,파일이름 전달
        try (InputStream inputStream = file.getInputStream()) {
            s3Service.uploadFile(inputStream, objectMetadata, fileName);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다 (%s)", file.getOriginalFilename()));
        }
        //s3Service에서 원래 파일이름을 전달하고 fileURL받기
        return s3Service.getFileUrl(fileName);
    }

	//기존 파일이름에서 unique한 파일이름+확장자 생성해서 반환
    private String createFileName(String originalFileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
    }

    //파일이름에서 확장자 받아오기
    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다", fileName));
        }
    }
    
  //이미지 목록 업로드
    public String[] uploadImages(MultipartFile[] files) {
       String[] fileNames = new String[files.length];
       int index=0;
       for(MultipartFile file: files) {
          //원래 파일이름을 unique하게 바꿔서 fileName에 저장
          String fileName = createFileName(file.getOriginalFilename());
          //ObjectMetadat객체를 원래 파일의 content type으로 설정
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            //s3service에 파일, objectmetadata,파일이름 전달
            try (InputStream inputStream = file.getInputStream()) {
                s3Service.uploadFile(inputStream, objectMetadata, fileName);
            } catch (IOException e) {
                throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다 (%s)", file.getOriginalFilename()));
            }
            fileNames[index++]=s3Service.getFileUrl(fileName);
            
       }
       
         //s3Service에서 원래 파일이름을 전달하고 fileURL받기
         return fileNames;
     }


}
