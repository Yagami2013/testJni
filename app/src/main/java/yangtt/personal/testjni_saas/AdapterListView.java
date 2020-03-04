package yangtt.personal.testjni_saas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by hj on 2018/11/9.
 */

public class AdapterListView extends BaseAdapter {
    private LinkedList<RecordItem> mData;
    private Context mContext;
    public AdapterListView(Context mContext,LinkedList<RecordItem> mData){
        this.mData=mData;
        this.mContext=mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(mContext).inflate(R.layout.item_list_button,parent,false);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.img_record_icon);
        TextView textView=(TextView)convertView.findViewById(R.id.txt_record_name);
        //Button button=(Button)convertView.findViewById(R.id.btn_list_recorder);
        //imageView.setBackgroundResource(mData.get(position).getIconResourceId());
        imageView.setImageResource(mData.get(position).getIconResourceId());
        textView.setText(mData.get(position).getName());
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
