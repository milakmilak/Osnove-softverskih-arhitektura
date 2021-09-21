package com.osa.osaproject.controller;

import com.osa.osaproject.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    private final ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @PostMapping(produces = "text/plain")
    public String handleImageUpload(@RequestParam("image") MultipartFile file) throws IOException {
        logger.info("POST '/api/v1/images': Adding new image in base64 encoding to DB.");

        return service.store(file);
    }

}
