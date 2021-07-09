package co4353distributedsystems.preferences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PreferencesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreferencesApplication.class, args);
    }

}
