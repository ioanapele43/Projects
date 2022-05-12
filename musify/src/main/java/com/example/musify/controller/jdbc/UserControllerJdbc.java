package com.example.musify.controller.jdbc;

import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.model.User;
import com.example.musify.repo.jdbc.UserRepository;
import com.example.musify.service.jdbc.UserServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

//@RestController
public class UserControllerJdbc {
   /* @Autowired
    private UserServiceJdbc userService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserRepository userRepository;

    /* @GetMapping
     public String helloSpring(@RequestParam String id){
         System.out.println("id : "+id);
         return userService.getMessage();
     }*/
    /*@GetMapping("/u")
    public String helloSpring() {

        return userService.getMessage();
    }

    @GetMapping("/user")
    public String getUserFromURL(@RequestParam String firstName, @RequestParam String lastName) {
        System.out.println(" first name: " + firstName + " and last name: " + lastName);
        return " first name: " + firstName + " <br> and<br> last name: " + lastName + " ";

    }

    @GetMapping("/allusers")
    public String getAllUsers() {
        userRepository = new UserRepository(dataSource);
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
    }

    @GetMapping("/getuser")
    public String getUserById(@RequestParam int id) {
        userRepository = new UserRepository(dataSource);
        List<User> users = userRepository.getUserById(id);
        // User u=userRepository.getUserById(id);
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
    }

    @PostMapping("/insertUser")
    public String insertUser(@RequestParam int id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String country, @RequestParam String role) {
        userRepository = new UserRepository(dataSource);
        try {
            userRepository.insertUser(new User(id, firstname, lastname, email, password, country, role));
        } catch (Exception e) {
            System.out.println("exista deja");
        }
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
        //localhost:8080/insertUser?firstname=bb&lastname=bb&email=bb&password=1234&country=romania&role=regular
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestParam int id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String country, @RequestParam String role) {
        userRepository = new UserRepository(dataSource);
        try {
            userRepository.updateUser(new User(id, firstname, lastname, email, password, country, role));
        } catch (Exception e) {
        }
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
        //localhost:8080/updateUser?firstname=bb&lastname=bb&email=bb&password=1234&country=romania&role=regular
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam int id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String country, @RequestParam String role) {
        userRepository = new UserRepository(dataSource);
        try {
            userRepository.deleteUser(new User(id, firstname, lastname, email, password, country, role));
        } catch (Exception e) {
        }
        List<User> users = userRepository.getALlUSers();
        AtomicReference<String> s = new AtomicReference<>("");
        users.forEach(u -> {
            System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole());
            s.set(s + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getPassword() + " " + u.getCountry() + " " + u.getRole() + "<br>");
        });
        return s.get();
        //localhost:8080/deleteUser?firstname=bb&lastname=bb&email=bb&password=1234&country=romania&role=regular
    }

    @GetMapping("/{id}")
    public UserViewDTO getUser(@PathVariable int id) {
        try {
            return userService.getUser(id);
        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping("/saveu")
    public UserViewDTO saveUSer(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/getUserDto")
    public UserDTO getUserDto(@RequestParam int id) {
        return userService.getUserDto(id);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        String token = userService.login(email, password);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }*/

    /*public UserViewDTO login(@RequestParam String email, @RequestParam String password){
        return userService.login(email, password);
    }*/
   /* @PostMapping("/Register")
    public UserViewDTO registerUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @GetMapping("/JustAdmin")
    public String justAdmin() {
        return userService.justAdmin();
    }
    /*@PostMapping("/logout")
    public void logout(@RequestParam String token){
        JwtUtils.invalidateToken(token);
    }*/
   /* @PostMapping
    public String post(@RequestBody User user){
        System.out.println("");
        return "";
    }

    PATH PARAMS_url/1
    QUERY PARAMS_url?name=Vlad
    BODY PARAMS(POST/PUT)
*/
   /*
   @GetMapping("{id}")
    public String helloSpring(Integer id){
        System.out.println("id : "+id);
        return userService.getMessage();
    }
   @GetMapping("/hello-spring")
    public String helloSpring(){
        return "hello spring";
    }
    */
}
