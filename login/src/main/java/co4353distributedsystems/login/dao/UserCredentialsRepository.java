package co4353distributedsystems.login.dao;

import co4353distributedsystems.login.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials,String> {
}
