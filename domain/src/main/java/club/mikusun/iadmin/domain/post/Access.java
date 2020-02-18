package club.mikusun.iadmin.domain.post;

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
public class Access {
    @Id
    @Column
    private int id;

    @Column
    private String resource_url;

    @Column
    private boolean opened;

}
