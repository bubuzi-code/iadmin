package club.mikusun.iadmin.post.service;

import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessService
        extends BaseService<Post_access, Integer> , ShiroAccessService<Post_access>{

}

