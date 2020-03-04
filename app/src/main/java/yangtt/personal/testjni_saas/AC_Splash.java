package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.networkbench.agent.impl.NBSAppAgent;
import yangtt.personal.testjni_saas.util.Tingyun;
import yangtt.personal.testjni_saas.LogY;
/**
 * Created by hj on 2018/12/25.
 */

public class AC_Splash extends mBaseActivity {
    private TextView textView;
    private Button skip;
    private  MyCountDownTimer timer;
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView=(TextView)findViewById(R.id.txt_splash_count);
        skip=(Button)findViewById(R.id.btn_skip);

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(AC_Splash.this,MainActivity2.class));
                //Tingyun.setAppStartEnd("AC_Splash.class");

                finish();

            }
        };
        handler.postDelayed(runnable,5000);

        timer=new MyCountDownTimer(5000,1000);
        timer.start();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                handler.removeCallbacks(runnable);
                startActivity(new Intent(AC_Splash.this,MainActivity2.class));

                finish();
            }
        });

        /*handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0:
                        startActivity(new Intent(AC_Splash.this,MainActivity2.class));
                        finish();
                        break;
                    case 1:
                        break;
                }
            }
        };*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        //LogY.wait(4);
        //NBSAppAgent.setUserIdentifier("userb");
        LogY.m("start end:"+System.currentTimeMillis());
        //onCreate called finish() and here will not run
    }

    @Override
    public void doSomeThing() {    }

    @Override
    protected void onDestroy() {
        if(timer != null){
            timer.cancel();
        }
        super.onDestroy();
    }

    class MyCountDownTimer extends CountDownTimer{
        public MyCountDownTimer(long millisInFuture,int countDownInterval){
            super(millisInFuture,countDownInterval);
        }
        @Override
        public void onFinish() {
            textView.setText("剩余 0 s");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            textView.setText("剩余 "+(millisUntilFinished+1000)/1000+" s");
        }
    }
}
