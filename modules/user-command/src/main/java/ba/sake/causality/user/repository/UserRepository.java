package ba.sake.causality.user.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ba.sake.causality.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findOneByName(String name);

}
