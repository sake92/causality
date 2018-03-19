package ba.sake.causality.user.service;

import ba.sake.causality.user.command.CreateUserCommand;

public interface UserService {

    void create(CreateUserCommand command);

}
