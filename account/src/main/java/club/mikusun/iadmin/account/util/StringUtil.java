package club.mikusun.iadmin.account.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class StringUtil {
    public static final String md5(String password , String salt){
        // 加密方式
        String hashAlgorithmName = "MD5";
        // 盐源码
        ByteSource byteSource = ByteSource.Util.bytes(salt);
        // 密码
        Object source = password;
        // 加密次数
        int hashIterations = 1024;
        SimpleHash result = new SimpleHash(hashAlgorithmName,source,salt,hashIterations);
        return result.toString();
    }

    public static void main(String[] args) {
        System.err.println(md5("123456","321654987"));
    }

}
