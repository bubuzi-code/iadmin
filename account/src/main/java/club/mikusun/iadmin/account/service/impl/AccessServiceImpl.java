package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.dao.AccessDao;
import club.mikusun.iadmin.account.service.AccessService;
import club.mikusun.iadmin.domain.account.Access;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl extends BaseServiceImpl<Access, Integer >
        implements AccessService {
    @Getter
    private AccessDao dao;
    public AccessServiceImpl(AccessDao dao) {
        super(dao);
        this.dao = dao;
    }
}
