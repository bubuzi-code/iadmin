package club.mikusun.iadmin.account.dao;

import club.mikusun.iadmin.domain.account.Access;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessDao extends JpaRepository<Access , Integer> {
}
