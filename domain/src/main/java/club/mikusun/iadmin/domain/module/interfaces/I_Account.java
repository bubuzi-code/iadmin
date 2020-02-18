package club.mikusun.iadmin.domain.module.interfaces;

public interface I_Account {
    String getSalt();
    String getPassword();

    /**
     * 将重要的字段置空,并返回自己
     * @return
     */
    I_Account ignoreMajor();
}
