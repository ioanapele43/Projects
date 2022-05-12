package com.example.musify.service.jdbc;

import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.exception.UnauthorizedException;
import com.example.musify.model.User;
import com.example.musify.repo.jdbc.UserRepository;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
public class UserServiceJdbc {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;


    public String getMessage() {
        return "hello from user service";
    }

    public UserViewDTO getUser(int id) {
        User user = userRepository.getUserById(id).get(0);
        return userMapper.toViewDto(user);
    }

    public UserDTO getUserDto(int id) {
        User user = null;
        if (userRepository.getUserById(id).size() > 0) {
            user = userRepository.getUserById(id).get(0);
        }

        UserDTO userDTO = userMapper.toDto(user);
        //String decodedPassword= new String(decoder.decode(userDTO.getPassword()));
        //userDTO.setPassword(decodedPassword);
        return userMapper.toDto(user);
    }

    public UserViewDTO saveUser(UserDTO userDTO) {

        User user = userMapper.toEntity(userDTO);
        // Base64.Encoder encoder = null;
        //user.setPassword(encoder.encodeToString(user.getPassword().getBytes()));
        userRepository.insertUser(user);
        return userMapper.toViewDto(user);
    }

    /*public UserViewDTO login(String email, String password){
        User user=null;
        if(userRepository.getUserByEmailPassword(email,password).size()>0) {
            user = userRepository.getUserByEmailPassword(email, password).get(0);
        }
        return userMapper.toViewDto(user);
    }*/
    public String login(String email, String password) {
        User user = null;
        if (userRepository.getUserByEmail(email).size() > 0) {
            user = userRepository.getUserByEmail(email).get(0);
        }
        if (user == null || !password.equals(user.getPassword())) {
            throw new UnauthorizedException("Email or password invalid");
        }
        return JwtUtils.generateToken(user.getId(), user.getEmail(), user.getRole());

    }

    public UserViewDTO register(UserDTO userDTO) {
        return saveUser(userDTO);
    }

    public void logout(String token) {
        JwtUtils.invalidateToken(token);
    }

    public String justAdmin() {
        String role = JwtUtils.getCurrentUserRole();
        if (role.equals("admin")) {
            return "Welcome admin";
        } else {
            throw new UnauthorizedException("you're not admin");
        }
    }
    //https://www.baeldung.com/java-aes-encryption-decryption
    /*
    public static String encrypt(String algorithm, String input, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    public String encryptPassword(String password) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKey key = generateKey(128);
        IvParameterSpec ivParameterSpec = generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = encrypt(algorithm, password, key, ivParameterSpec);

        return cipherText;
    }
    public String decryptPassword(String password) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKey key = generateKey(128);
        IvParameterSpec ivParameterSpec = generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = password;
        String plainText=decrypt(algorithm,cipherText,key,ivParameterSpec);
        return plainText;
    }*/
}
