package yangtt.personal.testjni_saas;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class AC_StartOption extends mBaseActivity{
    @Override
    public void doSomeThing() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_option);

        Button bt_initSaas=(Button)findViewById(R.id.initSaas);
        Button bt_initEA_Http=(Button)findViewById(R.id.initEAHttp);
        Button bt_initEA_Https=(Button)findViewById(R.id.initEAHttps);
        Button bt_initEA_Https_NoCert=(Button)findViewById(R.id.initEAHttpsNoCert);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.initSaas:
                        break;
                    case R.id.initEAHttp:
                        break;
                    case R.id.initEAHttps:
                        break;
                    case R.id.initEAHttpsNoCert:
                        break;
                }
            }
        };
        bt_initSaas.setOnClickListener(listener);
        bt_initEA_Http.setOnClickListener(listener);
        bt_initEA_Https.setOnClickListener(listener);
        bt_initEA_Https_NoCert.setOnClickListener(listener);
    }
}
