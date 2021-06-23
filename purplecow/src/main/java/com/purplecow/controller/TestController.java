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
import com.google.cloud.vision.v1.ImageSource;
import com.google.protobuf.ByteString;
import com.purplecow.mapper.AccountMapper;


import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vision.v1.Block;
import com.google.cloud.vision.v1.Page;
import com.google.cloud.vision.v1.Paragraph;
import com.google.cloud.vision.v1.Symbol;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.cloud.vision.v1.Word;
import com.google.protobuf.util.JsonFormat;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class TestController {

	@Autowired
    private AccountMapper accountMapper;



	@GetMapping("/upload")
	public String upload() {
		
		return "img_upload/img_upload";

	}
	
	  @PostMapping("/test")
	  public static void ImgVisionAPITest(@RequestParam(name="profile") MultipartFile file) throws Exception {
		  
		  }
	  
	
}
