package co4353distributedsystems.login.controller;

import co4353distributedsystems.login.model.UserCredentials;

import co4353distributedsystems.login.service.UserCredentialsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserCredentialsController {
    @Autowired
    private UserCredentialsService userCredentialsService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login")
    public List<UserCredentials> logInGetMethod() {
        return userCredentialsService.getAllUsers();
    }

    @GetMapping("/signup")
    public ResponseEntity signUpGetMethod() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity signUpPostMethod(@RequestBody UserCredentials userCredentials) {
        userCredentialsService.saveCredential(userCredentials);

        return new ResponseEntity(userCredentials, HttpStatus.OK);

    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity loginPostMethod(@RequestBody UserCredentials userCredentials) {
        UserCredentials databaseCredentials = userCredentialsService.getSingleUser(userCredentials);
        if (databaseCredentials.getPassword().equals(userCredentials.getPassword())) {
            List<String> loggedInUserPreferences = restTemplate.getForObject("http://movie-preferences/preferences/" + userCredentials.getUsername(), List.class);

            return new ResponseEntity(loggedInUserPreferences, HttpStatus.OK);
        } else {
            return new ResponseEntity(userCredentialsService.getSingleUser(userCredentials), HttpStatus.FORBIDDEN);
        }

    }
}
