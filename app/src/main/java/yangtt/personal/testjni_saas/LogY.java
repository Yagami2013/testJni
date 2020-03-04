package yangtt.personal.testjni_saas;

import android.util.Log;



/**
 * Created by hj on 2019/1/14.
 */

public class LogY{
    private static String tag="yttDebugTag";
    private boolean isDebug=true;
    public static void m(String msg){
        Log.d(tag,msg);
        /*if(BuildConfig.LOG){
            Log.d(tag,msg);
        }*/
    }
    public static void t(String msg){
        if(BuildConfig.LOG){
            Log.e(tag,msg);
        }
    }
    public static void wait(int num){
        String traceLabel=String.format("sleep-%d-s",num);
        try {
            Log.d(tag,"ANR started at:"+System.currentTimeMillis());
            Thread.sleep(num*1000);
            Log.d(tag,"ANR finished at:"+System.currentTimeMillis());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
