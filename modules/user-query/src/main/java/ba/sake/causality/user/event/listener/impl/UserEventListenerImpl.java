package ba.sake.causality.user.event.listener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ba.sake.causality.channel.ChannelProperties;
import ba.sake.causality.event.user.UserCreatedEvent;
import ba.sake.causality.user.entity.User;
import ba.sake.causality.user.event.listener.UserEventListener;
import ba.sake.causality.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserEventListenerImpl implements UserEventListener {

    private final UserRepository userRepository;

    @Autowired
    public UserEventListenerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @StreamListener(target = ChannelProperties.USERS_INPUT,
            condition = "headers['eventType']=='UserCreatedEvent'")
    public void on(UserCreatedEvent event) {
        log.info("User created: {}", event);
        User user = new User();
        user.setId(event.getUserId());
        user.setName(event.getName());
        userRepository.save(user);
    }

}
