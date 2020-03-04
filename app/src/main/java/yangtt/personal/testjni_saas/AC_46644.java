package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * Created by hj on 2018/12/24.
 */

public class AC_46644 extends mBaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_46644);

        ImageView image=(ImageView)findViewById(R.id.img_46644);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AC_46644.this,AC_Test.class));
            }
        });
    }

    @Override
    public void doSomeThing() {

    }
}
