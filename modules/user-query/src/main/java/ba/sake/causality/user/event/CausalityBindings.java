package ba.sake.causality.user.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import ba.sake.causality.channel.ChannelProperties;

public interface CausalityBindings {

    @Input(ChannelProperties.USERS_INPUT)
    SubscribableChannel usersInput();

}
