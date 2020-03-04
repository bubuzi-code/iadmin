package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.feign.AccessFeginClient;
import club.mikusun.iadmin.account.service.AccessService;
import club.mikusun.iadmin.db.data.Direction;
import club.mikusun.iadmin.domain.account.Account_access;
import club.mikusun.iadmin.webutils.result.account.Result;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessFeginClient accessFeginClient;

    @Override
    public List<Account_access> shiroFindAll(Direction direction, String... fields) {
        return accessFeginClient.all(direction, fields)
                .ifPresentAndConvertList(Account_access.class);
    }

}
