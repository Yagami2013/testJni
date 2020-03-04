package yangtt.personal.testjni_saas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by hj on 2018/11/23.
 */

public class AC_Chat extends mBaseActivity {
    private ArrayList<Object> mData=null;
    private AdapterMultiLayout adapter=null;
    private static final int Left=0;
    private static final int Right=1;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        mData = new ArrayList<Object>();
        for(int i = 0;i < 20;i++){
            switch ((int)(Math.random() * 2)){
                case Left:
                    mData.add(new SpeakOther("裂帛"));
                    break;
                case Right:
                    mData.add(new SpeakSelf("没事，不会只黑你一个~"));
                    break;
            }
        }
        adapter=new AdapterMultiLayout(AC_Chat.this,mData);
        listView=(ListView)findViewById(R.id.list_chat);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(AC_Chat.this,AC_Test.class));
            }
        });


    }

    @Override
    public void doSomeThing() {

    }
}
