package co4353distributedsystems.login.dao;

import co4353distributedsystems.login.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, String> {
    @Query("select user from UserCredentials user where user.username=?1")
    UserCredentials findByUsername(String username);
}
