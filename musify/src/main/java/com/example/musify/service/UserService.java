package com.example.musify.service;

import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.exception.UnauthorizedException;
import com.example.musify.model.User;
import com.example.musify.repo.UserRepositoryJPA;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.mappers.PlaylistMapper;
import com.example.musify.service.mappers.UserMapper;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;
    private final ValidationsService validationsService;
    private final PlaylistMapper playlistMapper;

    public UserService(UserRepositoryJPA userRepositoryJPA, UserMapper userMapper, ValidationsService validationsService, PlaylistMapper playlistMapper) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.userMapper = userMapper;
        this.validationsService = validationsService;
        this.playlistMapper = playlistMapper;
    }

    public List<UserViewDTO> getUsers() {
        return userRepositoryJPA.findAll()
                .stream()
                .map(userMapper::toViewDto)
                .collect(Collectors.toList());
    }

    public UserViewDTO getUserById(Integer id) {
        validationsService.checkIfAUserExists(id);
        return userMapper.toViewDto(userRepositoryJPA.getUserById(id));
    }

    public UserViewDTO getUserByEmailAndPassword(String email, String password) {
        return userMapper.toViewDto(userRepositoryJPA.findByEmailAndPassword(email, password));
    }

    @Transactional
    public UserViewDTO register(UserDTO userDTO) {
        byte[] bytes = userDTO.getPassword().getBytes();
        String encoded = String.valueOf(Hex.encode(bytes));
        userDTO.setPassword(encoded);
        User user = userMapper.toEntity(userDTO);
        user.setStatus("active");
        if (user.getEmail().endsWith("@arobs.com"))
            user.setRole("admin");
        else
            user.setRole("user");
        User userFromDatabase = userRepositoryJPA.save(user);
        return userMapper.toViewDto(userFromDatabase);
    }

    @Transactional
    public UserViewDTO updateUser(Integer id, UserDTO userDTO) {
        validationsService.checkIfAUserExists(id);
        User initialuser=userRepositoryJPA.getUserById(id);
        User user = userMapper.toEntity(userDTO);
        user.setId(id);
        byte[] bytes = userDTO.getPassword().getBytes();
        String encoded = String.valueOf(Hex.encode(bytes));
        user.setPassword(encoded);
        user.setStatus("active");
        user.setRole(initialuser.getRole());
        user.setPlaylistsCreated(initialuser.getPlaylistsCreated());
        user.setPlaylistsFollowed(initialuser.getPlaylistsFollowed());
        User userFromDatabase = userRepositoryJPA.save(user);
        return userMapper.toViewDto(userFromDatabase);
    }

    @Transactional
    public UserViewDTO setInactive(Integer id) {
        validationsService.checkIfAUserExists(id);
        User user = userRepositoryJPA.getUserById(id);
        user.setStatus("inactive");
        User userFromDatabase = userRepositoryJPA.getUserById(id);
        return userMapper.toViewDto(userFromDatabase);
    }

    @Transactional
    public UserViewDTO setActive(Integer id) {
        validationsService.checkIfAUserExists(id);
        User user = userRepositoryJPA.getUserById(id);
        user.setStatus("active");
        User userFromDatabase = userRepositoryJPA.getUserById(id);
        return userMapper.toViewDto(userFromDatabase);
    }

    @Transactional
    public String login(String email, String password) {
        User user = null;
        if (userRepositoryJPA.getUserByEmail(email) != null) {
            user = userRepositoryJPA.getUserByEmail(email);
        }
        byte[] bytes = password.getBytes();
        String encoded = String.valueOf(Hex.encode(bytes));
        if (user == null || !encoded.equals(user.getPassword()) || user.getStatus().equals("inactive")) {
            throw new UnauthorizedException("Email or password invalid");
        }
        return JwtUtils.generateToken(user.getId(), user.getEmail(), user.getRole());
    }

    public void logout(String token) {
        JwtUtils.invalidateToken(token);
    }

    @Transactional
    public UserViewDTO inactivateUser() {
        Integer id = JwtUtils.getCurrentUserId();
        User user = userRepositoryJPA.getUserById(id);
        user.setStatus("inactive");
        userRepositoryJPA.save(user);
        User userFromDatabase = userRepositoryJPA.getUserById(id);
        return userMapper.toViewDto(userFromDatabase);
    }

    @Transactional
    public UserViewDTO activateUser() {
        Integer id = JwtUtils.getCurrentUserId();
        User user = userRepositoryJPA.getUserById(id);
        user.setStatus("active");
        userRepositoryJPA.save(user);
        User userFromDatabase = userRepositoryJPA.getUserById(id);
        return userMapper.toViewDto(userFromDatabase);

    }



}
