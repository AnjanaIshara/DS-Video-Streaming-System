package co4353distributedsystems.preferences.resources;

import java.util.ArrayList;

public class UserPreferences {
    private int userid;
    private ArrayList choices=new ArrayList();

    public UserPreferences() {
    }

    public UserPreferences(int userid, ArrayList choices) {
        this.userid = userid;
        this.choices = choices;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public ArrayList getChoices() {
        return choices;
    }

    public void setChoices(ArrayList choices) {
        this.choices = choices;
    }
}
