package co4353distributedsystems.login.service;

import co4353distributedsystems.login.dao.UserCredentialsRepository;

import co4353distributedsystems.login.model.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCredentialsService {
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    public void saveCredential(UserCredentials userCredentials) {
        userCredentialsRepository.save(userCredentials);
    }

    public List<UserCredentials> getAllUsers() {
        return userCredentialsRepository.findAll();
    }

    public UserCredentials getSingleUser(UserCredentials postData) {
        return userCredentialsRepository.findById(postData.getUsername()).get();

    }
    public UserCredentials getUserByUserName(String username){
        return userCredentialsRepository.findByUsername(username);
    }


}
