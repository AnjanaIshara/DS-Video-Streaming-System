package co4353distributedsystems.login.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class UserPreferences {
    @Id
    private String username;
    @ElementCollection
    private List<String> choices;

    public UserPreferences() {
    }

    public UserPreferences(String username, List<String> choices) {
        this.username = username;
        this.choices = choices;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
