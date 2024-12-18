package com.sp.user.service;

import com.sp.user.dto.UserProfileDTO;
import com.sp.user.entity.UserProfile;

public interface UserProfileService {
    UserProfile createProfile(Long userId, UserProfileDTO userProfileDTO);

    UserProfile getProfileByUserId(Long userId);
}
