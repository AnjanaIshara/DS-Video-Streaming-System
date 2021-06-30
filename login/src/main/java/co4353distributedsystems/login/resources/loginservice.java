package co4353distributedsystems.login.resources;



import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class loginservice {
    private List<UserCredentials> users=new ArrayList<>(Arrays.asList());
    public List<UserCredentials> getUsers(){
        return users;
    }
    public void addUser(UserCredentials userCredentials){
        users=new ArrayList<>(Arrays.asList());
        users.add(userCredentials);
    }

    public void registerUser(UserCredentials userCredentials) {
        users=new ArrayList<>(Arrays.asList());
        users.add(userCredentials);
    }
}
