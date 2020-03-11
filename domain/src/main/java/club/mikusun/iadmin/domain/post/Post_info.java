package club.mikusun.iadmin.domain.post;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_info")
@NoArgsConstructor
@Data
public class Post_info {

    // 与post表的id单对单映射
    @Id
    @Column
    private int postId;

    // 文章状态
    @Column
    private int status;

    // 阅读量
    @Column
    private int readNum;

    // 点赞量
    @Column
    private int upvoteNum;

}
