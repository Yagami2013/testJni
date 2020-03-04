package yangtt.personal.testjni_saas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.LinkedList;

import yangtt.personal.testjni_saas.util.Crash;

/**
 * Created by hj on 2018/12/3.
 */

public class FG_Record extends mBaseFragment{
    private String content;

    private int value;
    private float scale;
    private int clickedItemId;
    private long date;
    private HealthRecord record;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        long overLapStart=getArguments().getLong("start");
        View view = inflater.inflate(R.layout.fg_content,container,false);
        //头信息
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText(content+txt_content.getText());
        //日历，显示康复时长及感冒频率
        final CalendarView calendarView=(CalendarView)view.findViewById(R.id.calendar);
        //状态设置，用于记录是否生病、症状、就诊、问题行为、生长曲线等

        date=calendarView.getDate();
        record=new HealthRecord(date);

        ListView listView=(ListView)view.findViewById(R.id.list_set_record);
        LinkedList<RecordItem> recordItems=new LinkedList<>();
        recordItems.add(new RecordItem("身高",R.drawable.shengao));
        recordItems.add(new RecordItem("体重",R.drawable.tizhong));
        recordItems.add(new RecordItem("头围",R.drawable.touwei));
        recordItems.add(new RecordItem("臭臭",R.drawable.chouchou));

        AdapterListView adapter=new AdapterListView(view.getContext(),recordItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        //test crash app
                        Crash.createJava(null);
                        clickedItemId=0;
                        showDialog(parent,200,0,80,9,0,0,"cm",true);
                        break;
                    case 1:
                        clickedItemId=1;
                        showDialog(parent,100,0,10,9,0,5,"kg",true);
                        break;
                    case 2:
                        clickedItemId=2;
                        showDialog(parent,50,0,20,9,0,0,"cm",true);
                        break;
                    case 3:
                        clickedItemId=3;
                        showDialog(parent,50,0,0,0,0,0,"次",false);
                        break;

                }
            }
        });
        return view;
    }

    public void showDialog(ViewGroup parent, int max1, int min1, int default1, int max2, int min2, int default2, final String unit, final boolean showMinutPicker){
        AlertDialog dialog=null;
        AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View myDialogView=inflater.inflate(R.layout.layout_picker,null,false);
        builder.setView(myDialogView);
        builder.setCancelable(true);
        dialog=builder.create();

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                float result= value +(float)scale/10;
                LogY.m("result:"+result);
                switch (clickedItemId){
                    case 0:
                        record.setHight(result);
                        break;
                    case 1:
                        record.setWeight(result);
                        break;
                    case 2:
                        record.setHeadSize(result);
                        break;
                    case 3:
                        record.setPooCount((int)result);
                        break;
                }
            }
        });
        NumberPicker weightPicker=myDialogView.findViewById(R.id.hourpicker);
        weightPicker.setMaxValue(max1);
        weightPicker.setMinValue(min1);
        weightPicker.setValue(default1);
        NumberPicker scallingPicker=myDialogView.findViewById(R.id.minuteicker);
        TextView point=myDialogView.findViewById(R.id.txt_point);
        if(!showMinutPicker){
            scallingPicker.setVisibility(View.INVISIBLE);
            point.setVisibility(View.INVISIBLE);
        }
        scallingPicker.setMaxValue(max2);
        scallingPicker.setMinValue(min2);
        scallingPicker.setValue(default2);
        TextView viewById=myDialogView.findViewById(R.id.txt_unit);
        viewById.setText(unit);

        NumberPicker.OnScrollListener listener=new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                switch (view.getId()){
                    case R.id.hourpicker:
                        value =view.getValue();
                        break;
                    case R.id.minuteicker:
                        scale=view.getValue();
                        break;
                }
                /*if(!showMinutPicker){
                    LogY.m("value:"+value+unit);
                }else {
                    float theWeight= value +(float)scale/10;
                    LogY.m("value:"+theWeight+unit);

                }*/
            }
        };

        weightPicker.setOnScrollListener(listener);
        scallingPicker.setOnScrollListener(listener);

        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public String doSomeThing() {
        return getClass().getName();
    }

    @Override
    public long getOverLapStart() {
        long overLapStart=getArguments().getLong("start");
        LogY.t("overLapStart:"+overLapStart);
        return overLapStart;
    }
}
