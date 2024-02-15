package com.boot.rest.base.service;

import com.boot.rest.base.model.Loyalty;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FormulaImageService {

    public String saveImage(String uploadDirectory, MultipartFile imageFile) throws IOException;

    public byte[] getImage(String imageDirectory, String imageName) throws IOException;




}
