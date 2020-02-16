package club.mikusun.iadmin.account.dao;

import club.mikusun.iadmin.domain.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role , Integer> {
}
