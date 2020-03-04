package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Created by hj on 2018/12/12.
 */

public class AC_ModeTest extends mBaseActivity {
    @Override
    public void doSomeThing() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        TextView textView = (TextView) findViewById(R.id.txt_show_acMode);
        textView.setText(this.toString());
        Button button = (Button) findViewById(R.id.btn_goto_next);
        Intent intent=getIntent();
        int flag=intent.getIntExtra("from",0);
        final Intent intent2;
        switch (flag){
            case 0:
                button.setText("Go To AC_SingleTask");
                intent2= new Intent(AC_ModeTest.this, AC_SingleTask.class);
                break;
            case 1:
                button.setText("Go To AC_SingleTop");
                intent2 = new Intent(AC_ModeTest.this, AC_SingleTop.class);
                break;
            default:
                intent2= new Intent(AC_ModeTest.this, AC_SingleTask.class);
                break;
        }
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          startActivity(intent2);
                                      }
                                  });
        Button button_self=(Button)findViewById(R.id.btn_goto_self);
        button_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AC_ModeTest.this, AC_ModeTest.class);
                startActivity(intent);
            }
        });

/*---------------------
            作者：liuhe688
            来源：CSDN
            原文：https://blog.csdn.net/liuhe688/article/details/6754323
            版权声明：本文为博主原创文章，转载请附上博文链接！*/
    }
}
