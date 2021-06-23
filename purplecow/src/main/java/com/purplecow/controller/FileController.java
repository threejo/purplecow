package com.purplecow.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageSource;
import com.google.protobuf.ByteString;
import com.purplecow.service.FileService;

/**
 * @author miho7
 *
 */

@RestController
public class FileController {

	@Autowired FileService fileService;


	private static void findname(String input) {
		Pattern pattern = Pattern.compile("\\n[ㄱ-하-ㅣ가-힣]{2,}\\n");
		Matcher matcher = pattern.matcher(input);
	
		if(matcher.find()) {
			String result = matcher.group();
			System.out.print(result+" \n"); 
		}
	}
	private static void findsocialnumber(String input) {
		Pattern pattern = Pattern.compile("\\d\\d\\d\\d\\d\\d-\\d\\d\\d\\d\\d\\d\\d");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) System.out.print(matcher.group()+" \n"); 
	}
	private static void finddrivernumber(String input) {
		Pattern pattern = Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d\\d\\d-\\d\\d");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) System.out.print(matcher.group()+" \n"); 
	}
	private static void findtype(String input) {
		Pattern pattern = Pattern.compile(".종..");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) System.out.print(matcher.group()+" \n"); 
	}
	private static void finddate(String input) {
		Pattern pattern = Pattern.compile("\\d\\d\\d\\d\\.\\d\\d\\.\\d\\d");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) System.out.print(matcher.group()+" \n"); 
	}
	
	@PostMapping("/api/v1/upload")
    public String uploadImage(@RequestParam(name="profile") MultipartFile file) {
		
	    try {
	    	detectTextGcs(fileService.uploadImage(file));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileService.uploadImage(file);
    }
	
	

	// Detects text in the specified remote image on Google Cloud Storage.
	  public static void detectTextGcs(String path) throws Exception {
	    List<AnnotateImageRequest> requests = new ArrayList<>();

	    ImageSource imgSource = ImageSource.newBuilder().setImageUri(path).build();
	    Image img = Image.newBuilder().setSource(imgSource).build();
	    Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
	    AnnotateImageRequest request =
	        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
	    requests.add(request);

	    // Initialize client that will be used to send requests. This client only needs to be created
	    // once, and can be reused for multiple requests. After completing all of your requests, call
	    // the "close" method on the client to safely clean up any remaining background resources.
	    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
	      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
	      List<AnnotateImageResponse> responses = response.getResponsesList();

	      for (AnnotateImageResponse res : responses) {
	        if (res.hasError()) {
	          System.out.format("Error: %s%n", res.getError().getMessage());
	          return;
	        }

	        // For full list of available annotations, see http://g.co/cloud/vision/docs
	        for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
	        	//String test = annotation.getDescription();
	        	findname(annotation.getDescription());
	        	findtype(annotation.getDescription());
	        	findsocialnumber(annotation.getDescription());
	        	finddrivernumber(annotation.getDescription());
	        	finddate(annotation.getDescription());
	           // System.out.format("Text: %s\n", annotation.getDescription());
	         // System.out.format("Position : %s%n", annotation.getBoundingPoly());
	          //System.out.format("text score : %s%n", annotation.getScore());
	         
	        }
	      }
	    }
	  }


}
