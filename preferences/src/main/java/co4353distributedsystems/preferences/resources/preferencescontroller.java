package co4353distributedsystems.preferences.resources;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class preferencescontroller {
    @Autowired
    private preferenceservice prefservice;
    @RequestMapping("/preferences")
    public List<UserPreferences> getAllpreferences(){
        return prefservice.getAllpreferences();
    }
    @RequestMapping(method = RequestMethod.POST,value="/preferences")
    public List<UserPreferences> registerPreference(@RequestBody UserPreferences userPreferences){
        prefservice.addPreference(userPreferences);
        return prefservice.getAllpreferences();
    }
}
