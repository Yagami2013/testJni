package yangtt.personal.testjni_saas;

/**
 * Created by hj on 2018/10/15.
 */

public class Java2CJNI {
    static {
        System.loadLibrary("Java2C");
    }
    public native String  java2c(int num);
}
