package com.wellcare.User.Service.Security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.wellcare.User.Service.Security.services.UserDetailsImpl;

@Service
public class SecurityService {

    public boolean isAuthorizedDoctor(Long userId, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails.getId().equals(userId);
    }
}
