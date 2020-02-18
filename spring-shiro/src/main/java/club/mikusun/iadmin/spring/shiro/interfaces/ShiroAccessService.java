package club.mikusun.iadmin.spring.shiro.interfaces;

import club.mikusun.iadmin.domain.module.interfaces.I_Access;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiroAccessService<T extends I_Access> {
    List<T> shiroFindAll(Sort var1);
}
