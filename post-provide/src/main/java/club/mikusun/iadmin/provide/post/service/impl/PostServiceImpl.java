package club.mikusun.iadmin.provide.post.service.impl;

import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.post.Post;
import club.mikusun.iadmin.provide.post.dao.PostDao;
import club.mikusun.iadmin.provide.post.service.PostService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends BaseServiceImpl<Post , Integer>
        implements PostService {

    @Getter
    private PostDao dao;

    public PostServiceImpl(PostDao dao) {
        super(dao);
        this.dao = dao;
    }
}
