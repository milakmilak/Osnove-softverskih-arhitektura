package com.osa.osaproject.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfiguration {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${image.path}")
    private String imagePath;

    public String getJwtSecret() {
        return this.jwtSecret;
    }

    public String getImagePath() {
        return this.imagePath;
    }

}
