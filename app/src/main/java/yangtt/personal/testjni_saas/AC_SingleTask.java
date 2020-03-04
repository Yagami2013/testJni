package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hj on 2018/12/12.
 * SingleTask:Activity 位于栈顶，再次打开不重新创建；否则,将栈中该Activity上面的都出栈，只有当栈中没有该类的实例时才新建
 */

public class AC_SingleTask extends mBaseActivity {
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
        button.setText("Go To ModeTest");
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(AC_SingleTask.this, AC_ModeTest.class);
                                          intent.putExtra("from",0);
                                          startActivity(intent);
                                      }
                                  });
        Button button_self=(Button)findViewById(R.id.btn_goto_self);
        button_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AC_SingleTask.this, AC_SingleTask.class);
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
