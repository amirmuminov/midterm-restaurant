package kz.muminov.midtermrestaraunt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.muminov.midtermrestaraunt.enums.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Roles name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    @JsonIgnore
    private List<User> user = new ArrayList<>();

    @Override
    public String getAuthority() {
        return name.toString();
    }

}
