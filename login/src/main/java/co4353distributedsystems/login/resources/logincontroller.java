package co4353distributedsystems.login.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class logincontroller {
    @Autowired
    private loginservice logservice;
    @RequestMapping("/login")
    public String showMethodError(){return  "POST method is required";}
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public List<UserCredentials> showCreds(@RequestBody UserCredentials userCredentials){
        logservice.addUser(userCredentials);

        return logservice.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/signup")
    public List<UserCredentials> registerCreds(@RequestBody UserCredentials userCredentials){
        logservice.registerUser(userCredentials);
        return logservice.getUsers();
    }
}
