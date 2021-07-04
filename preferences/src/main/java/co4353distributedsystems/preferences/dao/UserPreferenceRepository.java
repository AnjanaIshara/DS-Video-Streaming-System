package co4353distributedsystems.preferences.dao;

import co4353distributedsystems.preferences.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferenceRepository extends JpaRepository<UserPreferences, String> {
}
