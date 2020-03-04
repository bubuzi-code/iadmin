package club.mikusun.iadmin.provide.post.dao;


import club.mikusun.iadmin.domain.post.Post_access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostAccessDao extends JpaRepository<Post_access, Integer> {

}
