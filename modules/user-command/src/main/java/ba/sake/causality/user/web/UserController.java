package ba.sake.causality.user.web;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ba.sake.causality.user.command.CreateUserCommand;
import ba.sake.causality.user.service.UserService;
import ba.sake.causality.user.web.request.CreateUserRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void create(@RequestBody CreateUserRequest request) {
        CreateUserCommand command = new CreateUserCommand(UUID.randomUUID(), request);
        userService.create(command);
    }

}
