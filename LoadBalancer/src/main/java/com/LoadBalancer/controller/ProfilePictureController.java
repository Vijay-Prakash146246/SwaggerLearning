package com.LoadBalancer.controller;

import com.LoadBalancer.model.ProfilePicture;
import com.LoadBalancer.repository.ProfilePictureRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfilePictureController {
    @Autowired
    private ProfilePictureRepository profilePictureRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfilePicture(@RequestParam("file") MultipartFile file) {
        try {
            ProfilePicture profilePicture = new ProfilePicture();
            profilePicture.setFileName(file.getOriginalFilename());
            profilePicture.setContentType(file.getContentType());
            profilePicture.setData(file.getBytes());

            // Capture upload date and time
            profilePicture.setUploadDateTime(LocalDateTime.now());

            profilePictureRepository.save(profilePicture);

            return ResponseEntity.ok("Profile picture uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading profile picture.");
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadProfilePicture(@PathVariable Long id) {
        Optional<ProfilePicture> profilePictureOptional = profilePictureRepository.findById(id);

        if (profilePictureOptional.isPresent()) {
            ProfilePicture profilePicture = profilePictureOptional.get();
            ByteArrayResource resource = new ByteArrayResource(profilePicture.getData());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + profilePicture.getFileName() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

