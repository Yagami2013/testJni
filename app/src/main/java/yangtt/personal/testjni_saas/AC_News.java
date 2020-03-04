package yangtt.personal.testjni_saas;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import yangtt.personal.testjni_saas.util.TestUrls;

/**
 * Created by hj on 2018/12/20.
 */

public class AC_News extends mBaseActivity {

    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<News> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mContext = AC_News.this;
        fManager = getFragmentManager();
        bindViews();

        datas = new ArrayList<News>();
        /*for (int i = 1; i <= 20; i++) {
            News data = new News("新闻标题" + i, i + "~新闻内容~~~~~~~~");
            datas.add(data);
        }*/
        datas.add(new News("https_baidu_param", TestUrls.https_baidu_param));
        datas.add(new News("https_jd_param",TestUrls.https_jd_param));
        datas.add(new News("https_baidu_param",TestUrls.https_baidu));
        datas.add(new News("http_tianya",TestUrls.http_tianya));
        datas.add(new News("multi-requests","urls"));
        datas.add(new News("http_renminwang",TestUrls.http_renminwang));
        datas.add(new News("http_tianya404",TestUrls.http_404));
        datas.add(new News("default",TestUrls.http_400_param));
        datas.add(new News("sunkai",TestUrls.sk));
        datas.add(new News("download",TestUrls.download));
        datas.add(new News("media",TestUrls.media));
        datas.add(new News("跨应用",TestUrls.accross_app));
        FG_News_List nlFragment = new FG_News_List();
        nlFragment.setfManager(fManager);
        nlFragment.setDatas(datas);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_content, nlFragment);
        ft.commit();
    }


    private void bindViews() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
    }


    //点击回退键的处理：判断Fragment栈中是否有Fragment
    //没，双击退出程序，否则像是Toast提示
    //有，popbackstack弹出栈
    @Override
    public void onBackPressed() {
        if (fManager.getBackStackEntryCount() == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                /*Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();*/
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            fManager.popBackStack();
            txt_title.setText(R.string.grid_2);
        }
    }

    @Override
    public void doSomeThing() {

    }
}
