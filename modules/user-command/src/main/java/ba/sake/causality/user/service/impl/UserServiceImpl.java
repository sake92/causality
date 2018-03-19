package ba.sake.causality.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ba.sake.causality.user.command.CreateUserCommand;
import ba.sake.causality.user.entity.User;
import ba.sake.causality.user.event.producer.UserEventProducer;
import ba.sake.causality.user.repository.UserRepository;
import ba.sake.causality.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserEventProducer userEventProducer;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserEventProducer userEventProducer, UserRepository userRepository) {
        this.userEventProducer = userEventProducer;
        this.userRepository = userRepository;
    }

    public void create(CreateUserCommand command) {
        log.info("Creating user {}", command);
        User existingUser = userRepository.findOneByName(command.getRequest().getName());
        if (existingUser != null) {
            throw new RuntimeException("User already exists " + command.getRequest().getName());
        }
        userEventProducer.userCreated(command);
    }

}
