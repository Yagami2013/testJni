package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import yangtt.personal.testjni_saas.util.OkHttp3Builder;

/**
 * Created by hj on 2018/12/26.
 */

public class AC_ServiceTest extends mBaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_46638);

        Button btnStart=(Button)findViewById(R.id.btn_46638_longPress);
        Button btnStop=(Button)findViewById(R.id.btn_test_popWindow);
        btnStart.setText("Start Service");
        btnStop.setText("Stop Service");
        final Intent intent=new Intent(AC_ServiceTest.this,SV_PrintLog.class);
        //intent.setAction("yangtt.personal.testjni_saas.SV_PRINTLOG");
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttp3Builder builder=new OkHttp3Builder();
                builder.asyncGet();
                startService(intent);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
    }

    @Override
    public void doSomeThing() {

    }
}
