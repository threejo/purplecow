package com.purplecow.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;
import com.purplecow.mapper.AccountMapper;
@Controller
public class TestController {

	@Autowired
    private AccountMapper accountMapper;



	@GetMapping("/upload")
	public String upload() {
		
		return "img_upload/img_upload";

	}
	/*
	public static String fileToBinary(File file) {
	    String out = new String();
	    FileInputStream fis = null;
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 
	    try {
	        fis = new FileInputStream(file);
	    } catch (FileNotFoundException e) {
	        System.out.println("Exception position : FileUtil - fileToString(File file)");
	    }
	 
	    int len = 0;
	    byte[] buf = new byte[1024];
	    try {
	        while ((len = fis.read(buf)) != -1) {
	            baos.write(buf, 0, len);
	        }
	 
	        byte[] fileArray = baos.toByteArray();
	        out = new String(base64Enc(fileArray));
	 
	        fis.close();
	        baos.close();
	    } catch (IOException e) {
	        System.out.println("Exception position : FileUtil - fileToString(File file)");
	    }
	 
	    return out;
	}
	 
	public static byte[] base64Enc(byte[] buffer) {
	    return Base64.encodeBase64(buffer);
	}

	  private ResourceLoader resourceLoader;

	  // [START spring_vision_autowire]
	  private CloudVisionTemplate cloudVisionTemplate;
	  // [END spring_vision_autowire]

/*	
	  @GetMapping("/extractLabels")
	  public ModelAndView extractLabels(String imageUrl, ModelMap map) {
	    // [START spring_vision_image_labelling]
	    AnnotateImageResponse response =
	        this.cloudVisionTemplate.analyzeImage(
	            this.resourceLoader.getResource(imageUrl), Type.LABEL_DETECTION);

	    Map<String, Float> imageLabels =
	        response
	            .getLabelAnnotationsList()
	            .stream()
	            .collect(
	                Collectors.toMap(
	                    EntityAnnotation::getDescription,
	                    EntityAnnotation::getScore,
	                    (u, v) -> {
	                      throw new IllegalStateException(String.format("Duplicate key %s", u));
	                    },
	                    LinkedHashMap::new));
	    // [END spring_vision_image_labelling]

	    map.addAttribute("annotations", imageLabels);
	    map.addAttribute("imageUrl", imageUrl);

	    return new ModelAndView("result", map);
	  }

	  @GetMapping("/extractText")
	  public String extractText(File file){//String imageUrl) {
	    // [START spring_vision_text_extraction]
	    String textFromImage =
	        this.cloudVisionTemplate.extractTextFromImage(this.resourceLoader.getResource(fileToBinary(file)));
	    System.out.println( textFromImage);
	    return "Text from image: " + textFromImage;
	    // [END spring_vision_text_extraction]
	  }*/
	  
	  @PostMapping("/test")
	  public static void ImgVisionAPITest(@RequestParam(name="profile") MultipartFile file) throws Exception {
		  List<AnnotateImageRequest> requests = new ArrayList<>();
		  String content = new String(file.getBytes());
		  ByteString imgBytes = ByteString.readFrom(new FileInputStream(content));
		  Image img = Image.newBuilder().setContent(imgBytes).build();
		  Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
		  AnnotateImageRequest request =
		  AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		  requests.add(request);
		  try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			  BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			  List<AnnotateImageResponse> responses = response.getResponsesList();
			  for (AnnotateImageResponse res : responses) {
				  if (res.hasError()) {
					  System.out.printf("Error: %s\n", res.getError().getMessage());
					  return;
				  }
		  // For full list of available annotations, see http://g.co/cloud/vision/docs
				  for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
					  System.out.printf("Text: %s\n", annotation.getDescription());
					  System.out.printf("Position : %s\n", annotation.getBoundingPoly());
				  }
			  }
		  	}
		  }
	
}
