package club.mikusun.iadmin.provide.post.dao;


import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.post.Post_access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostAccessDao extends BaseService<Post_access, Integer> {

}
