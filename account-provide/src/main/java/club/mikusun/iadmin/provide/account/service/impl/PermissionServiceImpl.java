package club.mikusun.iadmin.provide.account.service.impl;


import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.account.Permission;
import club.mikusun.iadmin.provide.account.dao.PermissionDao;

import club.mikusun.iadmin.provide.account.service.PermissionService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl
        extends BaseServiceImpl<Permission, Integer>
        implements PermissionService {

    @Getter
    private PermissionDao dao;

    public PermissionServiceImpl(PermissionDao dao) {
        super(dao);
        this.dao = dao;
    }
}
