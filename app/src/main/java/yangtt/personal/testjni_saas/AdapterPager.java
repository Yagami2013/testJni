package yangtt.personal.testjni_saas;


import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * Created by hj on 2018/11/30.
 */

public class AdapterPager extends PagerAdapter {
    private ArrayList<View> viewList;
    public AdapterPager(){}
    public AdapterPager(ArrayList<View> viewList){
        super();
        this.viewList=viewList;
    }
    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=viewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
