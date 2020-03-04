package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*import com.networkbench.agent.impl.NBSAppAgent;
//import com.networkbench.agent.impl.crash.NativeCrashInterface;
import com.tencent.bugly.crashreport.CrashReport;*/

import yangtt.personal.testjni_saas.util.Crash;
import yangtt.personal.testjni_saas.util.TestUrls;

public class AC_Crash extends mBaseActivity {
    public TextView tv;
    public int num=0;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findButtonById();

        tv = (TextView) findViewById(R.id.sample_text);
        tv.setText("hello");
    }

    @Override
    protected void onResume() {
        super.onResume();
        int[] ar={1,2,3};
        Crash.indexOut(ar,num);
    }

    @Override
    public void doSomeThing() {

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    void findButtonById(){
        ButtonOnClickListener listener=new ButtonOnClickListener();
        Button mbutton=(Button)findViewById(R.id.bt_nativeCrash);
        mbutton.setOnClickListener(listener);
        Button btnActionState0=(Button)findViewById(R.id.bt_nativeInterface);
        btnActionState0.setOnClickListener(listener);
        Button btnActionState1=(Button)findViewById(R.id.bt_crash_on_resume);
        btnActionState1.setOnClickListener(listener);
        Button btnActionState2=(Button)findViewById(R.id.bt_startAC);
        btnActionState2.setOnClickListener(listener);
        Button btnActionState3=(Button)findViewById(R.id.bt_2);
        btnActionState3.setOnClickListener(listener);
        Button btnActionState4=(Button)findViewById(R.id.bt_3);
        btnActionState4.setOnClickListener(listener);
        Button btnJavaCrash=(Button)findViewById(R.id.btJavaCrash);
        btnJavaCrash.setOnClickListener(listener);
        Button btnJavaCrashWithNet=(Button)findViewById(R.id.btJavaCrashWithNet);
        btnJavaCrashWithNet.setOnClickListener(listener);

    }
    private class ButtonOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_nativeCrash:
                    tv.setText(stringFromJNI());
                    break;
                case R.id.bt_nativeInterface:
                    try {
                        System.loadLibrary("Newlens");
                    }catch (UnsatisfiedLinkError ule) {
                        LogY.m("Could not load native library");
                    }
                    //NativeCrashInterface.testCrash();
                    break;
                case R.id.bt_crash_on_resume:
                    num=3;
                    break;
                case R.id.bt_startAC:
                    startActivity();
                    break;
                case R.id.bt_2:
                    //CrashReport.testNativeCrash();
                    break;
                case R.id.bt_3:
                    Java2CJNI obj=new Java2CJNI();
                    tv.setText(obj.java2c(3));
                    break;
                case R.id.btJavaCrash:
                    Crash.createJava("");
                    break;
                case R.id.btJavaCrashWithNet:
                    Crash.createJava(TestUrls.http_tianya);
                    break;
            }
        }
    }

    public void startActivity() {
        Intent intent=new Intent();
        intent.setClass(this,MainActivity.class);
        AC_Crash.this.startActivity(intent);
    }
}

