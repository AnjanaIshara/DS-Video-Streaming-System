package co4353distributedsystems.preferences.resources;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class preferenceservice {
    private List<UserPreferences> allpreferences=new ArrayList<>(Arrays.asList());
    public List<UserPreferences> getAllpreferences(){
        return allpreferences;
    }
    public void addPreference(UserPreferences userPreferences){
        allpreferences.add(userPreferences);
    }
}
