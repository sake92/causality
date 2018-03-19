package ba.sake.causality.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import ba.sake.causality.user.event.CausalityBindings;

@SpringBootApplication
@EnableBinding(CausalityBindings.class)
public class UserQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserQueryApplication.class, args);
    }

}
