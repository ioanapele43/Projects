package com.example.musify.controller;

import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserViewDTO> getAllUsers() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.getUsers();
    }

    @GetMapping("/user/{idUser}")
    public UserViewDTO getUserById(@PathVariable Integer idUser) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.getUserById(idUser);
    }

    @PostMapping("/register")
    public UserViewDTO register(@RequestBody @Valid UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @PutMapping("/user")
    public UserViewDTO updateMyUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.updateUser(JwtUtils.getCurrentUserId(), userDTO);
    }

    @PutMapping("/user/{idUser}")
    public UserViewDTO updateUser(@PathVariable Integer idUser, @RequestBody @Valid UserDTO userDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.updateUser(idUser, userDTO);
    }

    @PutMapping("/user/{idUser}/active")
    public UserViewDTO setUserActive(@PathVariable Integer idUser) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.setActive(idUser);
    }

    @PutMapping("/user/{idUser}/inactive")
    public UserViewDTO setUserInactive(@PathVariable Integer idUser) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return userService.setInactive(idUser);
    }

    @PutMapping("/user/inactivate")
    public UserViewDTO inactivate() {
        return userService.inactivateUser();
    }


    @PutMapping("/user/logout")
    public void logout(@RequestParam String token){ userService.logout(token);}


}
