package com.boot.rest.base.service.impl;

import com.boot.rest.base.model.Loyalty;
import com.boot.rest.base.repository.LoyaltyRepository;
import com.boot.rest.base.repository.UserRepository;
import com.boot.rest.base.service.FormulaImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;


@Service
@Transactional
public class FormulaImageServiceImpl implements FormulaImageService {

    @Autowired
    private LoyaltyRepository loyaltyRepository;
    @Override
    public String saveImage(String uploadDirectory, MultipartFile imageFile) throws IOException {

        //String uploadDirectory = "src/main/resources/images";
        String uniqueFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }

    @Override
    public byte[] getImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return imageBytes;
        } else {
            return null; // Handle missing images
        }
    }
}
