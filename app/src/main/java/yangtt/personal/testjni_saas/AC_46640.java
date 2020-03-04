package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Created by hj on 2018/12/21.
 */

public class AC_46640 extends mBaseActivity {
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_46640);
        final Switch flag_value=(Switch)findViewById(R.id.sw_flag);
        final TextView flag_show=(TextView)findViewById(R.id.txt_flag);
        Button openButton=(Button)findViewById(R.id.btn_test_46640);



        flag_value.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag=flag_value.isChecked();
                String str=(flag==true?"true":"false");
                flag_show.setText("flag is "+str);
            }
        });
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if(flag){
                    intent.setClass(AC_46640.this,AC_Test.class);
                }else {
                    intent.setClass(AC_46640.this,AC_Chat.class);
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public void doSomeThing() {

    }
}
