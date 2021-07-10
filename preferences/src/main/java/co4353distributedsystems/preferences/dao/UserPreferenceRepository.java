package co4353distributedsystems.preferences.dao;

import co4353distributedsystems.preferences.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPreferenceRepository extends JpaRepository<UserPreferences, String> {
    @Query("select userpref from UserPreferences userpref where userpref.username=?1")
    UserPreferences getUserPreferencesByUserName(String userName);
    @Query("update UserPreferences set choices=?1 where username=?2")
    void updateUserChoices(List<String> newChoices,String userName);
}
