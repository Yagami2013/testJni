package yangtt.personal.testjni_saas.util;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ButtonList {
    Activity ac;
    public ButtonList(Activity ac){
        this.ac = ac;
    }
    public void initButton(int id,String methodName){
        try {
            Method method=this.ac.getClass().getMethod(methodName);
            addButton(this.ac,id,method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void addButton(final Activity view, int id, final Method method){
        Button bt = (Button)view.findViewById(id);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    method.invoke(view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        };
        bt.setOnClickListener(listener);
    }
}
