package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Created by hj on 2018/12/26.
 */

public class AC_46638 extends mBaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_46638);

        Button testLongPress=(Button)findViewById(R.id.btn_46638_longPress);
        testLongPress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(AC_46638.this,AC_Test.class));
                return false;
            }
        });
    }

    @Override
    public void doSomeThing() {

    }
}
