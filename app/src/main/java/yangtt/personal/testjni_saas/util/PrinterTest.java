package yangtt.personal.testjni_saas.util;

import android.os.Looper;
import android.util.Log;
import android.util.Printer;

import java.lang.reflect.Field;

import yangtt.personal.testjni_saas.LogY;

public class PrinterTest {

    private static Printer originPrinter;
    public static void test() {
        try {
            originPrinter = getFieldObject(Looper.getMainLooper(), "mLogging");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Printer printer = new Printer() {
            @Override
            public void println(String s) {
if (null != originPrinter) {
                    originPrinter.println(s);
                }

                if (null != originPrinter) {
                    LogY.m("printer not null");
                }
                Log.e("sdktest", "println");
            }
        };
        Looper.getMainLooper().setMessageLogging(printer);
    }
    public static <T> T getFieldObject(Object object, String s) throws Exception {
        Field filed = null;
        try {
            filed = object.getClass().getDeclaredField(s);
        } catch (Exception e) {
        }
        if (filed == null) {
            return null;
        }
        filed.setAccessible(true);
        return (T) filed.get(object);
    }
}
