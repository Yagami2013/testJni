package yangtt.personal.testjni_saas;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by hj on 2018/12/27.
 */

public class AC_PopWindow extends mBaseActivity {
    @Override
    public void doSomeThing() {

    }

    private Context mContext=AC_PopWindow.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_46638);
        Button testPopWindow=(Button)findViewById(R.id.btn_test_popWindow);
        testPopWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });

    }
    public void initPopWindow(View v){
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_popwindow,null,false);
        Button xixi=(Button)view.findViewById(R.id.btn_xixi);
        Button hehe=(Button)view.findViewById(R.id.btn_hehe);
        final PopupWindow window=new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        //window.setAnimationStyle(R.anim.fragment_slide_left_enter);
        window.setTouchable(true);
        window.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        window.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //window.showAsDropDown(v,50,0);
        window.showAtLocation(v,Gravity.BOTTOM,0,0);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"HoHoHo!",Toast.LENGTH_LONG).show();
                //window.dismiss();
            }
        };
        xixi.setOnClickListener(listener);
        hehe.setOnClickListener(listener);
    }
}
