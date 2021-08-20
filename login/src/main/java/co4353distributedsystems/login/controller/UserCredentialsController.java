package co4353distributedsystems.login.controller;

import co4353distributedsystems.login.model.CategorizedMovies;
import co4353distributedsystems.login.model.UserCredentials;

import co4353distributedsystems.login.security.MyUserDetailsService;
import co4353distributedsystems.login.service.UserCredentialsService;

import co4353distributedsystems.login.util.JwtUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserCredentialsController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserCredentialsService userCredentialsService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtUtil jwtTokenUtil;
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
            List<CategorizedMovies> suggestedMovies=new ArrayList<>();
            for (String s: loggedInUserPreferences){
                List<CategorizedMovies> movieResults=restTemplate.getForObject("http://categorized-movies/categorizedmovie/"+s , List.class);
                suggestedMovies.addAll(movieResults);
            }


            JSONObject returnObject=new JSONObject();
            returnObject.put("message","login ok");
            returnObject.put("Movie Categories",loggedInUserPreferences);
            returnObject.put("Movie results",suggestedMovies);


            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUsername(),userCredentials.getPassword()));

            }catch (BadCredentialsException e){
                throw new BadCredentialsException("Incorrect Username and Password",e);
            }

            final UserDetails userDetails= userDetailsService.loadUserByUsername(databaseCredentials.getUsername());
            final String jwt=jwtTokenUtil.generateToken(userDetails);
            returnObject.put("jwt",jwt);

            return new ResponseEntity(returnObject, HttpStatus.OK);
        } else {
            return new ResponseEntity(userCredentialsService.getSingleUser(userCredentials), HttpStatus.FORBIDDEN);
        }

    }
    @GetMapping("/auth")
    public ResponseEntity dummyGet() {

        JSONObject returnObject=new JSONObject();
        returnObject.put("msg","Auth Granted");

        return new ResponseEntity(returnObject,HttpStatus.OK);
    }


}
