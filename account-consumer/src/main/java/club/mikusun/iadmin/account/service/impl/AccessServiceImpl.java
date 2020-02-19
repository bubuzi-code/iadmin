package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.dao.AccessDao;
import club.mikusun.iadmin.account.service.AccessService;
import club.mikusun.iadmin.domain.account.Account_access;
import lombok.Getter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceImpl extends BaseServiceImpl<Account_access, Integer>
        implements AccessService {
    @Getter
    private AccessDao dao;
    public AccessServiceImpl(AccessDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Account_access> shiroFindAll(Sort var1) {
        return this.getDao().findAll(var1);
    }
}
