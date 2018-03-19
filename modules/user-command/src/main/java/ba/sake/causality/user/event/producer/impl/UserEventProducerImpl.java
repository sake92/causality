package ba.sake.causality.user.event.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import ba.sake.causality.channel.ChannelProperties;
import ba.sake.causality.event.Event;
import ba.sake.causality.event.user.UserCreatedEvent;
import ba.sake.causality.user.command.CreateUserCommand;
import ba.sake.causality.user.event.CausalityBindings;
import ba.sake.causality.user.event.producer.UserEventProducer;

@Component
public class UserEventProducerImpl implements UserEventProducer {

    private final CausalityBindings causalityBindings;

    @Autowired
    public UserEventProducerImpl(CausalityBindings causalityBindings) {
        this.causalityBindings = causalityBindings;
    }

    @Override
    public boolean userCreated(CreateUserCommand command) {
        UserCreatedEvent event = new UserCreatedEvent();
        event.setUserId(command.getUserId());
        event.setName(command.getRequest().getName());
        Message<Event> message = message(event);
        boolean wasSent = this.causalityBindings.usersOutput().send(message);
        return wasSent;
    }

    /* HELPERS */
    public static Message<Event> message(Event event) {
        String eventTypeName = event.getClass().getSimpleName();
        Message<Event> message = MessageBuilder.withPayload(event)
                .setHeaderIfAbsent(ChannelProperties.EVENT_TYPE_HEADER_NAME, eventTypeName).build();
        return message;
    }
}
