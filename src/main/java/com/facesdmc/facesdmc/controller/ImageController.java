package com.facesdmc.facesdmc.controller;
import com.facesdmc.facesdmc.constants.S3Constants;
import com.facesdmc.facesdmc.s3.S3Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {

    private final S3Service s3Service;

    @Value("${aws.s3.buckets.customer}")
    private String bucketName;

    public ImageController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        System.out.println("Getting image " + imageName);
        String key = S3Constants.REACT_IMAGES_FOLDER + imageName;
        byte[] imageBytes;

        try {
            imageBytes = s3Service.getObject(bucketName, key);
        } catch (software.amazon.awssdk.services.s3.model.NoSuchKeyException e) {
            System.out.println("Image not found for key: " + key);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                    .body(S3Constants.IMAGE_NOT_FOUND_MESSAGE.getBytes());
        }

        HttpHeaders headers = new HttpHeaders();
        if (imageName.toLowerCase().endsWith(".jpg") || imageName.toLowerCase().endsWith(".jpeg")) {
            headers.setContentType(MediaType.IMAGE_JPEG);
        } else if (imageName.toLowerCase().endsWith(".png")) {
            headers.setContentType(MediaType.IMAGE_PNG);
        } else {
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        }
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<String>> listImages() {
        List<String> images = s3Service.listImages(bucketName, S3Constants.REACT_IMAGES_FOLDER);
        return ResponseEntity.ok(images);
    }
}
