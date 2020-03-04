package yangtt.personal.testjni_saas;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import yangtt.personal.testjni_saas.util.Tingyun;

public class AC_UIDTest extends mBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setuid);

        final EditText editText=(EditText)findViewById(R.id.et_uid);
        Button button=(Button)findViewById(R.id.btn_setuid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid=editText.getText().toString();
                if(!"".equals(uid)){
                    Tingyun.setUserIdentifier(uid);
                }else {
                    Toast.makeText(AC_UIDTest.this,"input is null",Toast.LENGTH_LONG);
                }
            }
        });
    }

    @Override
    public void doSomeThing() {

    }
}
