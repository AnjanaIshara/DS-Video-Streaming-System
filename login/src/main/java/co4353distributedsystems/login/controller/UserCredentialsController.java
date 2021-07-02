package co4353distributedsystems.login.controller;

import co4353distributedsystems.login.model.UserCredentials;

import co4353distributedsystems.login.service.UserCredentialsService;
import org.apache.catalina.User;
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
    public ResponseEntity signUpGetMethod(){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/signup")
    public ResponseEntity signUpPostMethod(@RequestBody UserCredentials userCredentials){
        userCredentialsService.saveCredential(userCredentials);
        return new ResponseEntity(userCredentials,HttpStatus.OK);

    }
    @PostMapping("/login")
    public ResponseEntity loginPostMethod(@RequestBody UserCredentials userCredentials){
        UserCredentials databaseCredentials=userCredentialsService.getSingleUser(userCredentials);
        if(databaseCredentials.getPassword().equals(userCredentials.getPassword())){
            return new ResponseEntity(userCredentialsService.getSingleUser(userCredentials),HttpStatus.OK);
        }
        else{
            return new ResponseEntity(userCredentialsService.getSingleUser(userCredentials),HttpStatus.FORBIDDEN);
        }

    }
}
