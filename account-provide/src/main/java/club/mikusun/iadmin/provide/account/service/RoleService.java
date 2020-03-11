package club.mikusun.iadmin.provide.account.service;


import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.account.Role;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RoleService
        extends BaseService<Role, Integer> {

}
