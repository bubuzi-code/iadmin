package club.mikusun.iadmin.provide.post.service;

import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.post.Post_access;
import org.springframework.stereotype.Repository;

@Repository
public interface PostAccessService extends BaseService<Post_access , Integer> {

}
