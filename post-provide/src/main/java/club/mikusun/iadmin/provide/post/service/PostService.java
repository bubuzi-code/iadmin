package club.mikusun.iadmin.provide.post.service;

import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.post.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface PostService extends BaseService<Post , Integer> {

}
