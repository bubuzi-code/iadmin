package club.mikusun.iadmin.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "permission")
@NoArgsConstructor
@Data
public class Permission implements Serializable {

    @Id
    @Column
    private int id;

    @Column
    private String permission;

}
