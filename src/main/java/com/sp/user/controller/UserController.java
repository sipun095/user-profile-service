package com.sp.user.controller;

import com.sp.user.dto.UserProfileDTO;
import com.sp.user.entity.UserProfile;
import com.sp.user.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/{userId}")
    public ResponseEntity<UserProfile> createProfile(@PathVariable Long userId, @RequestBody UserProfileDTO userProfileDTO) {
        UserProfile createdProfile = userProfileService.createProfile(userId, userProfileDTO);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable Long userId) {
        UserProfile userProfile = userProfileService.getProfileByUserId(userId);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

}
