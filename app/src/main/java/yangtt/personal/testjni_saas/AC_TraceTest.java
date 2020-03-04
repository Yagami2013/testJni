package yangtt.personal.testjni_saas;

import android.os.Bundle;


/**
 * Created by hj on 2019/1/18.
 */

public class AC_TraceTest extends mBaseActivity {
    @Override
    public void doSomeThing() {}
    public String url="http://m.baidu.com";
    public String url_error="https://sdktest.networkbench.com/400.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpUtil.get(url);
            }
        }).start();
        LogY.wait(1);
    }*/


    @Override
    protected void onResume() {
        super.onResume();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int responseCode=OkHttpUtil.get(url_error);
                    LogY.m("response code:"+responseCode);
                    String[] urls=getRequestUrl();
                    OkHttpUtil.asyncGet(urls);
                }
            }).start();
            LogY.wait(2);
        }
    String[] getRequestUrl(){
        String[] urls=new String[18];
        for(int i=400;i<418;i++){
            urls[i-400]="https://sdktest.networkbench.com/"+i+".php";
        }
        return urls;
    }
}
