package com.sp.user.service.impl;

import com.sp.user.dto.UserProfileDTO;
import com.sp.user.entity.User;
import com.sp.user.entity.UserProfile;
import com.sp.user.repository.UserProfileRepository;
import com.sp.user.repository.UserRepository;
import com.sp.user.service.UserProfileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserProfile createProfile(Long userId, UserProfileDTO userProfileDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(existingUser); // Linking the profile to a user
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setPhone(userProfileDTO.getPhone());
        userProfile.setAddress(userProfileDTO.getAddress());
        userProfile.setProfilePictureUrl(userProfileDTO.getProfilePictureUrl());
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getProfileByUserId(Long userId) {
        return userProfileRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
