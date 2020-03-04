package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by hj on 2018/12/21.
 */

public class AC_46768 extends mBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_46768);
    }
    public void buttonOnClick(View view){
        startActivity(new Intent(AC_46768.this,AC_Chat.class));
    }

    @Override
    public void doSomeThing() {

    }
}
