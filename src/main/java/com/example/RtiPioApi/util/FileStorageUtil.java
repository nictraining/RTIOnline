package com.example.RtiPioApi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component // Mark this class as a Spring component so it can be autowired
public class FileStorageUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileStorageUtil.class);

    @Value("${app.file-storage.upload-dir}")
    private String uploadDir;

    @Value("${app.file-storage.base-url}")
    private String baseUrl;

    public String uploadFile(MultipartFile file) throws IOException, IllegalArgumentException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Cannot upload empty or null file.");
        }


        String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());


        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;

        try {

            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            Files.createDirectories(uploadPath); // Ensure the directory exists


            Path targetLocation = uploadPath.resolve(uniqueFileName);


            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);


            String fileUrl = baseUrl + uniqueFileName;
            logger.info("File uploaded successfully: {}", fileUrl);
            return fileUrl;
        } catch (IOException ex) {
            logger.error("Could not store file {}. Please try again! {}", uniqueFileName, ex.getMessage(), ex);
            throw new IOException("Could not store file " + uniqueFileName + ". " + ex.getMessage(), ex);
        }
    }

    public boolean deleteFile(String fileUrl) {
        if (fileUrl == null || fileUrl.isEmpty() || !fileUrl.startsWith(baseUrl)) {
            logger.warn("Invalid file URL for deletion: {}", fileUrl);
            return false;
        }

        try {
            String fileName = fileUrl.substring(baseUrl.length());
            Path filePath = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(fileName);

            if (Files.exists(filePath)) {
                Files.delete(filePath);
                logger.info("File deleted successfully: {}", fileUrl);
                return true;
            } else {
                logger.warn("File not found for deletion: {}", fileUrl);
                return false;
            }
        } catch (IOException ex) {
            logger.error("Could not delete file {}. {}", fileUrl, ex.getMessage(), ex);
            return false;
        }
    }
}
