package club.mikusun.iadmin.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.ConstraintMode.NO_CONSTRAINT;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Role implements Serializable {

    @Id
    @Column
    private int id;

    @Column
    private Integer pid;

    @Column
    private String name;

    @ManyToMany(
            cascade = {CascadeType.REFRESH}
    )
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id",foreignKey =@ForeignKey(value = NO_CONSTRAINT) )},
            foreignKey = @ForeignKey(value = NO_CONSTRAINT),
            inverseJoinColumns = {@JoinColumn(name = "permissions_id",foreignKey =@ForeignKey(value = NO_CONSTRAINT) )},
            inverseForeignKey = @ForeignKey(value = NO_CONSTRAINT)
    )
    private Set<Permission> permissions;
}
