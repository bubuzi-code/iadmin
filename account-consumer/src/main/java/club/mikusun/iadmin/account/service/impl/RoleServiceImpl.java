package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.dao.RoleDao;
import club.mikusun.iadmin.account.service.RoleService;
import club.mikusun.iadmin.domain.account.Role;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {
    @Getter
    private RoleDao dao;
    public RoleServiceImpl(RoleDao dao) {
        super(dao);
        this.dao = dao;
    }
}
