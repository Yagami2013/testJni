package yangtt.personal.testjni_saas;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

/**
 * Created by hj on 2019/1/14.
 */

public abstract class mBaseFragment extends Fragment {
    public long onCreateStart;
    public long onStartStart;
    public boolean isCreated=false;
    public long onResumeEnd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        onCreateStart=System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        isCreated=true;
        LogY.t(getClass().getSimpleName()+" onCreate run");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogY.t(getClass().getSimpleName()+" onCreateView run");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        onStartStart=System.currentTimeMillis();
        super.onStart();
        LogY.t(getClass().getSimpleName()+" onStart run");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogY.t(getClass().getSimpleName()+" onResume run");
        String className=getClass().getSimpleName();
        onResumeEnd=System.currentTimeMillis();
        long overLapStart=getOverLapStart();
        if(isCreated==false){
            LogY.t(getClass().getSimpleName()+" onCreate not run.");
            LogY.m(className+" LoadTime:"+(onResumeEnd-onStartStart));
            LogY.m(className+" overLap LoadTime:"+(onResumeEnd-overLapStart));
        }else {
            LogY.m(className+" LoadTime:"+(onResumeEnd-onCreateStart));
            LogY.m(className+" overLap LoadTime:"+(onResumeEnd-overLapStart));
        }
        isCreated=false;
    }
    public abstract String doSomeThing();
    public abstract long getOverLapStart();
}
