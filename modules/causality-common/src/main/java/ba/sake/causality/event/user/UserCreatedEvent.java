package ba.sake.causality.event.user;

import java.util.UUID;
import ba.sake.causality.event.Event;
import lombok.Data;

/**
 * @author sakib
 */
@Data
public class UserCreatedEvent implements Event {

    private UUID userId;
    private String name;

}
