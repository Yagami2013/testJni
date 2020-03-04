package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

/**
 * Created by hj on 2018/12/21.
 */

public class AC_Test extends mBaseActivity {
    @Override
    public void doSomeThing() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button test=(Button)findViewById(R.id.testButton);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AC_Test.this,AC_SingleTask.class));
            }
        });
    }
}
