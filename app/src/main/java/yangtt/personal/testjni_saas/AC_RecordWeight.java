package yangtt.personal.testjni_saas;

import android.os.Bundle;

import android.util.Log;
import android.widget.NumberPicker;

/**
 * Created by hj on 2018/12/13.
 */

public class AC_RecordWeight extends mBaseActivity {
    @Override
    public void doSomeThing() {

    }

    protected NumberPicker myPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_picker);
        myPicker=(NumberPicker)findViewById(R.id.hourpicker);
        myPicker.setMaxValue(100);
        myPicker.setMinValue(0);
        myPicker.setValue(50);
        myPicker.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                int value=view.getValue();
                Log.d("yttNBSAgent",""+value);
            }
        });
    }
}
