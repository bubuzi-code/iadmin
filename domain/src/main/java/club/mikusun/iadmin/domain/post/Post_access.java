package club.mikusun.iadmin.domain.post;

import club.mikusun.iadmin.domain.module.interfaces.I_Access;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "access")
@NoArgsConstructor
@Data
public class Post_access implements I_Access {
    @Id
    @Column
    private int id;

    @Column
    private String resource_url;

    @Column
    private boolean opened;

}
