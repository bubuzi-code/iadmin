package club.mikusun.iadmin.provide.account.service.impl;


import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.account.Role;
import club.mikusun.iadmin.provide.account.dao.RoleDao;

import club.mikusun.iadmin.provide.account.service.RoleService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl
        extends BaseServiceImpl<Role, Integer>
        implements RoleService {
    @Getter
    private RoleDao dao;
    public RoleServiceImpl(RoleDao dao) {
        super(dao);
        this.dao = dao;
    }
}
