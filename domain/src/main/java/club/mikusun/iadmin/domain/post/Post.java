package club.mikusun.iadmin.domain.post;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Data
public class Post implements Serializable {

    @Id
    @Column
    private int id;

    // 文章主题
    @Column
    private String subject;

    // 文章正文
    @Column
    private String main;

    // 创建时间
    @Column
    private int createTime;

    // 最后修改时间
    @Column
    private int lastUpdateTime;

    // 作者id
    @Column(columnDefinition = "")
    private int actuatorId;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.REFRESH )
    @JoinColumn(name="actuatorId" ,foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) ,insertable = false , updatable = false)
    private Actuator actuator;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name="id" ,referencedColumnName = "postId",foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Post_info postInfo;
}
