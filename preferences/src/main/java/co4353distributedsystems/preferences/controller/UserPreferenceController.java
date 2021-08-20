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

    @CrossOrigin
    @PostMapping("/preferences")
    public ResponseEntity preferencesPostMethod(@RequestBody UserPreferences userPreferences) {
        userPreferenceService.savePreferences(userPreferences);
        return new ResponseEntity(userPreferences, HttpStatus.OK);
    }

    @GetMapping("/preferences/{username}")
    public List<String> singleUser(@PathVariable String username) {
        List<String> userPreferencesList = userPreferenceService.getPreferencesByUsername(username);
        return userPreferencesList;
    }
    @PostMapping("/addpreferences")
    public ResponseEntity editPreferences(@RequestBody UserPreferences userPreferences){
        UserPreferences dataInDB=userPreferenceService.getUserPreference(userPreferences.getUsername());
        dataInDB.getChoices().removeAll(userPreferences.getChoices());
        dataInDB.getChoices().addAll(userPreferences.getChoices());
        userPreferenceService.updateChoices(dataInDB.getChoices(),userPreferences.getUsername());
        return new ResponseEntity(userPreferenceService.getPreferencesByUsername(userPreferences.getUsername()),HttpStatus.OK);
    }
    @PostMapping("/removepreferences")
    public ResponseEntity removePreferences(@RequestBody UserPreferences userPreferences){
        UserPreferences dataInDB=userPreferenceService.getUserPreference(userPreferences.getUsername());
        dataInDB.getChoices().removeAll(userPreferences.getChoices());
        userPreferenceService.updateChoices(dataInDB.getChoices(),userPreferences.getUsername());
        return new ResponseEntity(userPreferenceService.getPreferencesByUsername(userPreferences.getUsername()),HttpStatus.OK);

    }



}
