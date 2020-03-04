package yangtt.personal.testjni_saas;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FG_UI extends mBaseFragment {
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ui, container, false);
        mContext=view.getContext();
        initViewPager(view);
        initGridView(view);
        initListView(view);
        //initFragment(view);
        return view;
    }

    @Override
    public String doSomeThing() {
        return getClass().getName();
    }
    public long getOverLapStart() {
        long overLapStart=getArguments().getLong("start");
        LogY.t("overLapStart:"+overLapStart);
        return overLapStart;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void initViewPager(final View view){
        ViewPager viewPager=(ViewPager)view.findViewById(R.id.scrollView);
        ArrayList<View> arrayList=new ArrayList<>();
        LayoutInflater inflater=getLayoutInflater();
        View item1=inflater.inflate(R.layout.layout_item_viewpager1,null,false);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(),AC_Test.class));
            }
        });
        arrayList.add(item1);
        arrayList.add(inflater.inflate(R.layout.layout_item_viewpager2,null,false));
        arrayList.add(inflater.inflate(R.layout.layout_item_viewpager3,null,false));
        arrayList.add(inflater.inflate(R.layout.layout_item_viewpager4,null,false));
        AdapterPager adapter=new AdapterPager(arrayList);
        viewPager.setAdapter(adapter);
    }

    public void initGridView(View view){
        GridView gridView=(GridView)view.findViewById(R.id.grid);
        ArrayList<Icon> mData=new ArrayList<>();
        mData.add(new Icon(R.mipmap.happy,"聊天"));
        mData.add(new Icon(R.mipmap.angery,"RadioButton"));
        mData.add(new Icon(R.mipmap.sad,"新闻"));
        mData.add(new Icon(R.mipmap.shocked,"静态fragment"));
        gridView.setAdapter(new AdapterBase<Icon>(mData,R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setText(R.id.txt_grid,obj.getiName());
                holder.setImageResource(R.id.img_grid,obj.getiId());
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        intent=new Intent(parent.getContext(),AC_Chat.class);
                        break;
                    case 1:
                        intent=new Intent(parent.getContext(),AC_RadioButton.class);
                        break;
                    case 2:
                        intent=new Intent(parent.getContext(),AC_News.class);
                        break;
                    case 3:
                        intent=new Intent(parent.getContext(),AC_Test.class);
                        break;
                    default:
                        intent=new Intent(parent.getContext(),AC_Chat.class);
                        break;
                }
                startActivity(intent);
            }
        });

    }
    public void initListView(View view){
        List<Icon> mData=new LinkedList<Icon>();
        mData.add(new Icon(R.mipmap.if_grapes_2003194,"Activity未重写onCreate"));
        mData.add(new Icon(R.mipmap.if_lemon_2003191,"Activity未重写onResume"));
        mData.add(new Icon(R.mipmap.if_mango_2003198,"SingleTaskActivity"));
        mData.add(new Icon(R.mipmap.if_apple_2003193,"SingleTopActivity"));
        mData.add(new Icon(R.mipmap.if_orange_2003192,"46640相同按钮打开不同页面"));
        mData.add(new Icon(R.mipmap.if_pear_2003196,"46768按钮id为空"));
        mData.add(new Icon(R.mipmap.if_pineapple_2003197,"菠萝"));
        mData.add(new Icon(R.mipmap.if_pomegranate_2003195,"石榴"));
        mData.add(new Icon(R.mipmap.if_strawberry_2003199,"草莓"));
        mData.add(new Icon(R.mipmap.if_watermelon_2003190,"西瓜"));

        AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                Context mContext=parent.getContext();
                switch (position){
                    case 0:
                        intent=new Intent(mContext,AC_Window.class);
                        break;
                    case 1:
                        intent=new Intent(mContext,AC_RadioButton.class);
                        break;
                    case 2:
                        intent=new Intent(mContext,AC_SingleTask.class);
                        break;
                    case 3:
                        intent=new Intent(mContext,AC_SingleTop.class);
                        break;
                    case 4:
                        intent=new Intent(mContext,AC_46640.class);
                        break;
                    case 5:
                        intent=new Intent(mContext,AC_46768.class);
                        break;
                    default:
                        intent=new Intent(mContext,AC_SingleTop.class);
                        break;
                }
                startActivity(intent);
                /*Toast.makeText(view.getContext(),"ListItem "+position+" Clicked",Toast.LENGTH_SHORT).show();*/
            }
        };
        MyAdapter myAdapter=new MyAdapter((LinkedList<Icon>)mData,mContext);
        ListView listView=(ListView)view.findViewById(R.id.list);
        listView.setOnItemClickListener(onItemClickListener);
        listView.setAdapter(myAdapter);

    }
    public void initFragment(View view){
        FG_Hide fragment=new FG_Hide();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fg_testHide,fragment);
        transaction.commit();

    }
}
