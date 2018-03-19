package ba.sake.causality.user.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private UUID id;
    private String name;

}
