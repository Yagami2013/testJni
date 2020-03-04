package yangtt.personal.testjni_saas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hj on 2018/12/19.
 */

public class FG_Hide extends mBaseFragment{
    @Override
    public String doSomeThing() {
        return getClass().getName();
    }

    @Override
    public long getOverLapStart() {
        return 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.layout_fg_hide, container, false);
        return view;
    }
}
