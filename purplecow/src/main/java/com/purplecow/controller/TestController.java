package com.purplecow.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.codec.binary.Base64;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature.Type;
import com.purplecow.mapper.AccountMapper;
@Controller
public class TestController {

	@Autowired
    private AccountMapper accountMapper;



	@GetMapping("/upload")
	public String upload() {
		
		return "img_upload/img_upload";

	}
	
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

	  /**
	   * This method downloads an image from a URL and sends its contents to the Vision API for label
	   * detection.
	   *
	   * @param imageUrl the URL of the image
	   * @param map the model map to use
	   * @return a string with the list of labels and percentage of certainty
	   */
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
	  }
	
}
