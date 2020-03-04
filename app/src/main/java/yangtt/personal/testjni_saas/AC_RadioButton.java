package yangtt.personal.testjni_saas;

import android.os.Bundle;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by hj on 2018/12/4.
 */

public class AC_RadioButton extends mBaseActivity {
    @Override
    public void doSomeThing() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_radio_button);

        setRadioButtonClickEvent();
    }
    public void setRadioButtonClickEvent(){
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=(RadioButton)findViewById(checkedId);
                Toast.makeText(getApplicationContext(),"RadioGroup点击事件，你选了"+radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void setOtherButtonClickEvent(){
        
    }
}
