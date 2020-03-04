package club.mikusun.iadmin.domain.post;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Data
public class Post {

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

    // 文章状态
    @Column
    private int status;
}
