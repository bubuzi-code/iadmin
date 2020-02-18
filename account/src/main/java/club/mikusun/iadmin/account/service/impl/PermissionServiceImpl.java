package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.dao.PermissionDao;
import club.mikusun.iadmin.account.service.PermissionService;
import club.mikusun.iadmin.domain.account.Permission;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Integer> implements PermissionService {

    @Getter
    private PermissionDao dao;

    public PermissionServiceImpl(PermissionDao dao) {
        super(dao);
        this.dao = dao;
    }
}
