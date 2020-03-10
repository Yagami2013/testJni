package yangtt.personal.testjni_saas;

import android.app.Application;
import android.content.Context;

import java.util.List;

import yangtt.personal.testjni_saas.util.OkHttp3Builder;
import yangtt.personal.testjni_saas.util.Test;
import yangtt.personal.testjni_saas.util.TestUrls;
import yangtt.personal.testjni_saas.util.Tingyun;
import yangtt.personal.testjni_saas.LogY;
/*import com.tencent.bugly.crashreport.CrashReport;*/

/**
 * Created by hj on 2018/10/31.
 */

public class yApplication extends Application {


    private final String TAG="yttNBSAgent";
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //Test call interface before init
        //NBSAppAgent.reportError("called before init",null);
        new Test().setAppStartTime(System.currentTimeMillis());
        LogY.m("start begin:"+System.currentTimeMillis());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        OkHttp3Builder builder=new OkHttp3Builder();
        builder.get(TestUrls.chunk_baike);

        //Bugly.init(getApplicationContext());
        Tingyun.init(getApplicationContext());
        //Tingyun.initRN(getApplicationContext());
        //Tingyun.initBAByHttp(getApplicationContext());

        //Tingyun.sleepWithCustomTrace(1);
        //Bugtags.start("89261ba9df8c988a496b9472ed56ef07", this, Bugtags.BTGInvocationEventBubble);
    }
    public String getTAG(){
        return TAG;
    }
}
