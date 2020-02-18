package club.mikusun.iadmin.spring.shiro.interfaces;



import club.mikusun.iadmin.domain.module.interfaces.I_Account;


public interface ShiroAccountService<T extends I_Account> {
//    T shiroFindAccountByAccountStr(String account_str) ;
//    T shiroFindAccountByUid(int uid);

    /**
     * 使用authc的模块必须重写的方法
     * @param account_str
     * @return
     */
    default T shiroFindAccountByAccountStr(String account_str){
        // 未实现方法,
        return null;
    }
    /**
     * 使用OAuth2的模块必须重写的方法
     * 该接口
     * @param redisKey
     */
    default T shiroFindAccountByRedisKey(String redisKey){
        return null;
    }

}
