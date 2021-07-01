package co4353distributedsystems.login.controller;

import co4353distributedsystems.login.model.UserCredentials;

import co4353distributedsystems.login.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCredentialsController {
    @Autowired
    private UserCredentialsService userCredentialsService;
    @GetMapping("/login")
    public List<UserCredentials> logInGetMethod(){
        return userCredentialsService.getAllUsers();
    }
    @GetMapping("/signup")
    public ResponseEntity signupGetMethod(){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/signup")
    public ResponseEntity signupPostMthod(@RequestBody UserCredentials userCredentials){
        userCredentialsService.saveCredential(userCredentials);
        return new ResponseEntity(userCredentials,HttpStatus.OK);

    }
}
