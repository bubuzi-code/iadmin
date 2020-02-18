package club.mikusun.iadmin.domain.module.interfaces;

/**
 * 解决在不同库中表名相同产生的异常
 * 如shiro中的access,在不同包下
 */
public interface I_Access {
    String getResource_url();
    boolean isOpened();
}
