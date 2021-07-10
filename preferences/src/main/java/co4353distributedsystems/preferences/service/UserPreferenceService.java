package co4353distributedsystems.preferences.service;

import co4353distributedsystems.preferences.dao.UserPreferenceRepository;
import co4353distributedsystems.preferences.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferenceService {
    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    public List<String> getPreferencesByUsername(String username) {
        return userPreferenceRepository.findById(username).get().getChoices();
    }

    public void savePreferences(UserPreferences postData) {
        userPreferenceRepository.save(postData);
    }
    public UserPreferences getUserPreference(String userName){
        return userPreferenceRepository.getUserPreferencesByUserName(userName);
    }
    public void updateChoices(List<String> newChoices,String userName){
        userPreferenceRepository.updateUserChoices(newChoices, userName);
    }
}
