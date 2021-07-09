package co4353distributedsystems.login.security;

import co4353distributedsystems.login.model.UserCredentials;
import co4353distributedsystems.login.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserCredentialsService userCredentialsService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserCredentials userCredentials=userCredentialsService.getUserByUserName(userName);

        return new User(userCredentials.getUsername(),userCredentials.getPassword(),new ArrayList<>());
    }
}
