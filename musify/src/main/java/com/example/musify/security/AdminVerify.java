package com.example.musify.security;

import com.example.musify.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;


public class AdminVerify {
    public static void checkIfTheUserLoggedIsAdmin() {
        String role = JwtUtils.getCurrentUserRole();
        if (!role.equals("admin"))
            throw new UnauthorizedException("you're not admin");
    }
}
