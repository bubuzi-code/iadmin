package club.mikusun.iadmin.provide.account.service.impl;


import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.account.Account_access;
import club.mikusun.iadmin.provide.account.dao.AccessDao;

import club.mikusun.iadmin.provide.account.service.AccessService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl extends BaseServiceImpl<Account_access, Integer>
        implements AccessService {
    @Getter
    private AccessDao dao;
    public AccessServiceImpl(AccessDao dao) {
        super(dao);
        this.dao = dao;
    }

}
