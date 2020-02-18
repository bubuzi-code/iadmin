package club.mikusun.iadmin.post.dao;


import club.mikusun.iadmin.domain.post.Post_access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessDao extends JpaRepository<Post_access, Integer> {
}
