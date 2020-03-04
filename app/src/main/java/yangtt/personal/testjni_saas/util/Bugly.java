package yangtt.personal.testjni_saas.util;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;

public class Bugly {
    public static String buglyId="900002307";
    public static String buglyIdTest="674554b356";
    public static String test1="aeae7c0d48";
    public static void init(Context context){
        /*第三个参数为SDK调试模式开关，调试模式的行为特性如下：
        输出详细的Bugly SDK的Log；
        每一条Crash都会被立即上报；
        自定义日志将会在Logcat中输出。
        建议在测试阶段建议设置成true，发布时设置为false。
        * */
        CrashReport.initCrashReport(context, buglyIdTest, true);
    }

}
