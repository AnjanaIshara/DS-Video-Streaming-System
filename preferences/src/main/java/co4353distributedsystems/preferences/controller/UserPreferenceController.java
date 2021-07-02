package co4353distributedsystems.preferences.controller;

import co4353distributedsystems.preferences.model.UserPreferences;
import co4353distributedsystems.preferences.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPreferenceController {
    @Autowired
    private UserPreferenceService userPreferenceService;
    @PostMapping("/preferences")
    public ResponseEntity preferencesPostMethod(@RequestBody UserPreferences userPreferences){
        userPreferenceService.savePreferences(userPreferences);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/preferences/{username}")
    public List<String> singleUser(@PathVariable String username){
        List<String> userPreferencesList=userPreferenceService.getPreferencesByUsername(username);
        return userPreferencesList;
    }

}
