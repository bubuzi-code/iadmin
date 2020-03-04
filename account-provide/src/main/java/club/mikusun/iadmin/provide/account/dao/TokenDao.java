package club.mikusun.iadmin.provide.account.dao;

import club.mikusun.iadmin.domain.account.Account_Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenDao extends JpaRepository<Account_Token , Integer>{
    @Query("select a from Account_Token a where a.uid=:uid")
    Account_Token findOneByUid(int uid);
    @Query("select a from Account_Token a where a.token=:token")
    Account_Token findOneByToken(String token);
}
