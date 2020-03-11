package club.mikusun.iadmin.domain.post;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actuator")
@NoArgsConstructor
@Data
public class Actuator {
    @Id
    @Column
    private int uid;

    @Column
    private String name;


}
