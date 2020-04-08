package yangtt.personal.testjni_saas;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import yangtt.personal.testjni_saas.util.Ok3Util;
import yangtt.personal.testjni_saas.util.OkHttp3Builder;
import yangtt.personal.testjni_saas.util.TestUrls;
import yangtt.personal.testjni_saas.util.UrlConnectionBuilder;

/**
 * Created by hj on 2018/12/20.
 */

public class FG_News_List extends mBaseFragment implements AdapterView.OnItemClickListener{
        private FragmentManager fManager;
        private ArrayList<News> datas;
        private ListView list_news;

        public FG_News_List(){}

    @Override
    public String doSomeThing() {
        return null;
    }

    @Override
    public long getOverLapStart() {
        return 0;
    }

    public void setfManager(FragmentManager fManager) {
        this.fManager = fManager;
    }

    public FragmentManager getfManager() {
        return fManager;
    }

    public void setDatas(ArrayList<News> datas) {
        this.datas = datas;
    }

    public ArrayList<News> getDatas() {
        return datas;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fg_news_list,container,false);
        list_news = (ListView) view.findViewById(R.id.list_news);
        AdapterNewsList myAdapter = new AdapterNewsList(datas, getActivity());
        list_news.setAdapter(myAdapter);
        list_news.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        FG_News_Content ncFragment = new FG_News_Content();
        String content=datas.get(position).getContent();
        OkHttp3Builder builder=new OkHttp3Builder();
        switch (position){
            case 0:
            case 1:
            case 2:
                new UrlConnectionBuilder().get(content);
                break;
            case 3:
            case 5:
            case 8:
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        OkHttpUtil.get(content);
//                    }
//                }).start();

                builder.get(content);
                break;
            case 4:
                Ok3Util.okHttpGet_nostream(TestUrls.cdata);
                Ok3Util.okHttpGet_nostream(TestUrls.qq);
                Ok3Util.okHttpGet_nostream(TestUrls.news);
                Ok3Util.okHttpGet_nostream(TestUrls.sk_content);
//                builder.asyncGet(TestUrls.cdata);
//                builder.asyncGet(TestUrls.qq);
//                builder.asyncGet(TestUrls.news);
                break;
            case 7:
                builder.get(TestUrls.cdata);
                builder.get(TestUrls.qq);
                builder.get(TestUrls.news);
                break;
            case 9:
                Ok3Util.okHttpGet_nostream(content);
                break;
            case 10:
                builder.get(content);
                break;
            case 11:
                new UrlConnectionBuilder().get(content);
                break;
            case 12:
                break;
            case 13:
                break;
                default:
                    builder.get(content);
                    break;
        }

        Bundle bd = new Bundle();
        bd.putString("content", content);
        ncFragment.setArguments(bd);
        //获取Activity的控件
        TextView txt_title = (TextView) getActivity().findViewById(R.id.txt_title);
        txt_title.setText(datas.get(position).getTitle());
        //加上Fragment替换动画
        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_content, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();

    }
}
