package com.osa.osaproject.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    String store(MultipartFile file) throws IOException;

}
