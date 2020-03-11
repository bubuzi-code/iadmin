package club.mikusun.iadmin.webutils.asserts;

import club.mikusun.iadmin.db.data.BadRequestException;

public class HttpAssert {
    public static void nonNullBad(Object object , String message){
        if (object == null) {
            throw new BadRequestException(message);
        }
    }
}
