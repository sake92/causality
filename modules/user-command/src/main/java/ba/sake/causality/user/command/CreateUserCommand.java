package ba.sake.causality.user.command;

import java.util.UUID;
import ba.sake.causality.user.web.request.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserCommand {

    private UUID userId;
    private CreateUserRequest request;

}
