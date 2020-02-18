package club.mikusun.iadmin.post.service.impl;

import club.mikusun.iadmin.domain.module.interfaces.I_Access;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.post.dao.AccessDao;
import club.mikusun.iadmin.post.service.AccessService;
import lombok.Getter;
import org.springframework.data.domain.Sort;

import java.util.List;

public class AccessServiceImpl extends BaseServiceImpl<Post_access , Integer> implements AccessService {
    @Getter
    private AccessDao dao;
    public AccessServiceImpl(AccessDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Post_access> shiroFindAll(Sort var1) {
        return this.getDao().findAll(var1);
    }
}
