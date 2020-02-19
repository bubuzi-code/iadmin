package club.mikusun.iadmin.account.dao;

import club.mikusun.iadmin.domain.account.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission , Integer> {
}
