package dio.dio.springsecurity.controller;

import dio.dio.springsecurity.model.User;
import dio.dio.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {
    @Autowired
    private UserRepository userRepository; //included

    @GetMapping
    public String welcome() {
        return "Welcome to my Spring Boot Web API";
    }
    @GetMapping("/list-users")
    public ResponseEntity<List<User>> listAll() { //included
        List<User> allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }
    @GetMapping("/users")
//    @PreAuthorize("hasAnyRole('MANAGERS','USERS')")
    public String users() {
        return "Authorized user";
    }
    @GetMapping("/managers")
//    @PreAuthorize("hasRole('MANAGERS')")
    public String managers() {
        return "Authorized manager";
    }
}
