package club.mikusun.iadmin.spring.shiro.interfaces;

import club.mikusun.iadmin.domain.account.Access;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiroAccessDao {
    List<Access> findAll(Sort var1);
}
