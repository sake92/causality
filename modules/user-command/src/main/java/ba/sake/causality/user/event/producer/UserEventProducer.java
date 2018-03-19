package ba.sake.causality.user.event.producer;

import ba.sake.causality.user.command.CreateUserCommand;

public interface UserEventProducer {

    boolean userCreated(CreateUserCommand command);

}
