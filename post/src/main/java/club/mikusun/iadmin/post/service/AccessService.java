package club.mikusun.iadmin.post.service;

import club.mikusun.iadmin.domain.module.interfaces.I_Access;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessService extends BaseService<Post_access, Integer> , ShiroAccessService<Post_access>{
    List<Post_access> shiroFindAll(Sort var1);

}

