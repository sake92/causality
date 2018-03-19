package ba.sake.causality.user.event.listener;

import ba.sake.causality.event.user.UserCreatedEvent;

public interface UserEventListener {

    void on(UserCreatedEvent event);

}
