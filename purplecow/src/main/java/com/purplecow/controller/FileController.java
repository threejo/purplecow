package com.purplecow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.purplecow.service.FileService;

/**
 * @author miho7
 *
 */

@RestController
public class FileController {

	@Autowired FileService fileService;


	@PostMapping("/api/v1/upload")
    public String uploadImage(@RequestPart MultipartFile file) {
        return fileService.uploadImage(file);
    }



}
