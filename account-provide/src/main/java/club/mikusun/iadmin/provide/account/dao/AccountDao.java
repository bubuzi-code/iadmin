package club.mikusun.iadmin.provide.account.dao;

import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends BaseService<Account,Integer> {

    @Query("select a from Account a where a.account_str=:account")
    Account findAccountByAccount(@Param("account") String account);

}
