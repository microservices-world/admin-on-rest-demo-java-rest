package aor.demo.crud;

import aor.demo.crud.enums.Role;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@PrimaryKeyJoinColumn(name="id")
@Entity
@Where(clause="published=1")
public class Client extends PlatformUser {
    public String role = getUserRole().getRole().toString().toLowerCase();

    public Client() {
        super();

    }
    public Client(String email, List<GrantedAuthority> roles) {
        super(email, roles);
    }
    @Override
    public UserRole getUserRole() {
        return new UserRole(id, Role.CLIENT);
    }

    @JsonCreator
    public Client(int id) {
        this.id = id;
    }
}