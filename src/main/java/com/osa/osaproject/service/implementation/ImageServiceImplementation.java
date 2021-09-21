package com.osa.osaproject.service.implementation;

import com.osa.osaproject.configuration.PropertyConfiguration;
import com.osa.osaproject.service.ImageService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class ImageServiceImplementation implements ImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImplementation.class);

    private final String imagePath;

    public ImageServiceImplementation(PropertyConfiguration config) {
        this.imagePath = config.getImagePath();
    }

    @Override
    public String store(MultipartFile file) throws IOException {
        createDirectoryIfNotExists();

        String extension = getExtension(file);

        String imageName = Base64.getEncoder().encodeToString(file.getBytes());

        try(OutputStream os = Files.newOutputStream(Paths.get(imagePath, imageName), CREATE_NEW)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("ImageServiceImpl, image name: {}", imageName);

        return imageName;
    }

    private String getExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String extension = null;

        if(fileName != null) {
            extension = fileName.substring(fileName.lastIndexOf(".") + 1)
                    .toLowerCase();
        }

        return extension;
    }

    private void createDirectoryIfNotExists() {
        if(!Files.exists(Paths.get(imagePath))) {
            try {
                Files.createDirectory(Paths.get(imagePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
