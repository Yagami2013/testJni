package yangtt.personal.testjni_saas;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import yangtt.personal.testjni_saas.util.Ok3Util;
import yangtt.personal.testjni_saas.util.OkHttp3Builder;
import yangtt.personal.testjni_saas.util.TestUrls;
import yangtt.personal.testjni_saas.util.Tingyun;
import yangtt.personal.testjni_saas.util.UrlConnectionBuilder;

public class FG_Test extends ListFragment {
    private ListView listView;
    String[] cases={
            "46768 features-id为空",
            "46644 text-Button、图片、ListItem、GridItem",
            "46640 同一按钮打开不同页面",
            "46641 隐藏fragment",
            "46638 function-长按、滑动打开页面",
            "悬浮框",
            "Webview 页面",
            "Trace Test",
            "卡顿测试",
            "Service Test",
            "Crash Test",
            "UID Test",
            "AC_net",
            "CellInfoTest",
            "TestCustomError",
            "Test React-Native"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,cases));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Log.d(TAG,"position:"+position+" id:"+id);
        //startActivity(new Intent(this.getContext(),AC_Test.class));
        Intent intent=new Intent();
        Context context=this.getContext();
        switch (position){
            case 0:
                intent.setClass(context,AC_46768.class);
                break;
            case 1:
                intent.setClass(context,AC_46644.class);
                break;
            case 2:
                intent.setClass(context,AC_46640.class);
                break;
            case 3:
                intent.setClass(context,AC_46641.class);
                break;
            case 4:
                intent.setClass(context,AC_46638.class);
                break;
            case 5:
                intent.setClass(context,AC_PopWindow.class);
                break;
            case 6:
                intent.setClass(context,AC_Webview.class);
                break;
            case 7:
                intent.setClass(context,AC_TraceTest.class);
                break;
            case 8:
                LogY.m("anr start....."+System.currentTimeMillis());
                Ok3Util.okHttpGet_nostream(TestUrls.accross_app);
                new UrlConnectionBuilder().get(TestUrls.accross_app);
                Ok3Util.okHttpGet_nostream(TestUrls.chunk_baike);
                //LogY.wait(6);
                for(int i=0;i<5;i++){
                    LogY.wait(1);
                    Tingyun.setCrashMsg("anrMsg","CustomAnrAdditionalMessage");
                    Tingyun.setMianBaoXie("我是面包屑");
                    new UrlConnectionBuilder().get();
                    new UrlConnectionBuilder().post();
                    new OkHttp3Builder().get(TestUrls.http_long_time_response);
                    new OkHttp3Builder().asyncGet();
                }
                LogY.m("anr end ......"+System.currentTimeMillis());
                /*UrlConnectionBuilder.get(TestUrls.https_jd_param);
                UrlConnectionBuilder.get(TestUrls.http_400_param);
                UrlConnectionBuilder.get(TestUrls.https_400_param);*/
                //LogY.wait(6);
                intent.setClass(context,AC_ANR.class);
                break;
            case 9:
                intent.setClass(context,AC_ServiceTest.class);
                break;
            case 10:
                intent.setClass(context,AC_Crash.class);
                break;
            case 11:
                intent.setClass(context,AC_UIDTest.class);
                break;
            case 12:
                intent.setClass(context,AC_net.class);
                break;
            case 13:
                intent.setClass(context,AC_GSMCellLocation.class);
                break;
            case 14:
                intent.setClass(context,AC_TestButtons.class);
                break;
            case 15:
                intent.setClass(context,AC_ReactNative.class);
                break;
            default:
                intent.setClass(context,AC_PopWindow.class);
                break;
        }
        startActivity(intent);
    }
}
