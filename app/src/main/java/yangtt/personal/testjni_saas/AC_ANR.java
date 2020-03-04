package yangtt.personal.testjni_saas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

//import yangtt.personal.testjni_saas.util.PrinterTest;

/**
 * Created by hj on 2018/12/27.
 */

public class AC_ANR extends mBaseActivity {
    @Override
    public void doSomeThing() {

    }

    private Context mContext = AC_ANR.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LogY.wait(6);
        setContentView(R.layout.activity_anr);
        Button btnDisptch = (Button) findViewById(R.id.conflictPrinter);
        Button btnGC=(Button)findViewById(R.id.AnrTooMuchGC);
        btnDisptch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PrinterTest.test();
                LogY.wait(5);
                startActivity(new Intent(AC_ANR.this,AC_46640.class));
            }
        });
        btnGC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<50000;i++){
                    new TestPic();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Exception e = new Exception();
        e.printStackTrace();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Exception e = new Exception();
        e.printStackTrace();
    }


}
