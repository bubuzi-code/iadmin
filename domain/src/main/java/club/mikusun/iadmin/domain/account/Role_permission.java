package club.mikusun.iadmin.domain.account;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Table(name = "role_permission",indexes = {
        @Index(name = "keys",columnList = "role_id,permissions_id" , unique = true)
})
@Data
public class Role_permission {
    @Id
    @Column(nullable = false)
    private int role_id;

    @Id
    @Column(nullable = false)
    private int permissions_id;

}
