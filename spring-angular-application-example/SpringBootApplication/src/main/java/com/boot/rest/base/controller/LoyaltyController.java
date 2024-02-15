package com.boot.rest.base.controller;

import com.boot.rest.base.model.Loyalty;
import com.boot.rest.base.model.User;
import com.boot.rest.base.repository.LoyaltyRepository;
import com.boot.rest.base.service.FormulaImageService;
import com.boot.rest.base.service.LoyaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "loyalty")
@CrossOrigin(origins = "http://localhost:4200")
public class LoyaltyController {

    @Autowired
    LoyaltyService loyaltyService;

    @Autowired
    FormulaImageService formulaImageService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Loyalty createLoyalty(@RequestBody Loyalty loyalty)
    {
        return loyaltyService.saveLoyalty(loyalty);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Loyalty> findAll() {

        return this.loyaltyService.findAll();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("path") String path,
                                             @RequestParam("file") MultipartFile file) {
        String message = "";
        try {

            String uniqueFileName = formulaImageService.saveImage(path,file);
            //storageService.save(file);

            message = "Uploaded the file successfully: " + uniqueFileName;
            return ResponseEntity.status(HttpStatus.OK).body(new String(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).
                    body(new String(message));
        }
    }
}
