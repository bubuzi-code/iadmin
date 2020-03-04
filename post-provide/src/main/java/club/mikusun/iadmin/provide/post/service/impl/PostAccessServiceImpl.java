package club.mikusun.iadmin.provide.post.service.impl;

import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.provide.post.dao.PostAccessDao;
import club.mikusun.iadmin.provide.post.service.PostAccessService;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PostAccessServiceImpl extends BaseServiceImpl<Post_access , Integer>
        implements PostAccessService {
    @Getter
    private PostAccessDao dao;
    public PostAccessServiceImpl(PostAccessDao dao) {
        super(dao);
        this.dao = dao;
    }
}
