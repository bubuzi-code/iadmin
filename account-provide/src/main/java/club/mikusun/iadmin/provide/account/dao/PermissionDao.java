package club.mikusun.iadmin.provide.account.dao;

import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.account.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends BaseService<Permission , Integer> {
}
