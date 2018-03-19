package ba.sake.causality.user.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import ba.sake.causality.channel.ChannelProperties;

public interface CausalityBindings {

    @Output(ChannelProperties.USERS_OUTPUT)
    MessageChannel usersOutput();

    @Input(ChannelProperties.USERS_INPUT)
    SubscribableChannel usersInput();

}
