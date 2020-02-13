package club.mikusun.iadmin.account.util;


import net.bytebuddy.utility.RandomString;

import java.util.Random;

public class R {
    private static final char[] RESOURCE_CODE ={
            'A','B','C','D','E','F','G','H','I','J','K','L',
            'M','N','O','P','Q','R','S','T','U','V','W','X',
            'Y','Z','a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t','u','v','w',
            'x','y','z','1','2','3','4','5','6','7','8','9','0'
    };
    public static String randomString(int length){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(RESOURCE_CODE[random.nextInt(RESOURCE_CODE.length)]);
        }
        return stringBuffer.toString();
    }
}
