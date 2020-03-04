package yangtt.personal.testjni_saas;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by hj on 2019/1/14.
 */

public abstract class mBaseActivity extends AppCompatActivity {
    private Handler handler;
    public long onCreateStart;
    public long onStartStart;
    public boolean isCreated=false;
    public long onResumeEnd;
    public Bundle argumentsSender=new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        onCreateStart=System.currentTimeMillis();
        isCreated=true;
        super.onCreate(savedInstanceState);
        LogY.t(getLocalClassName()+" onCreate run at:"+onCreateStart);
    }

    @Override
    protected void onStart() {
        onStartStart=System.currentTimeMillis();
        if(!isCreated){
            argumentsSender.putLong("start",onStartStart);}

        super.onStart();
        LogY.t(getLocalClassName()+" onStart run");
    }

    @Override
    protected void onResume() {
        super.onResume();
        doSomeThing();
        onResumeEnd=System.currentTimeMillis();
        String className=getLocalClassName();
        if(isCreated==false){
            LogY.t(className+" onCreate not run.");
            LogY.m(className+" LoadTime:"+(onResumeEnd-onStartStart));
        }else {
            LogY.m(className+" LoadTime:"+(onResumeEnd-onCreateStart));
        }
        isCreated=false;
        LogY.t(className+" onResume run");
    }
    public abstract void doSomeThing();
}
