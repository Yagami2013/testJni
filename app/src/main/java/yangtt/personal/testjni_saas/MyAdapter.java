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
 * Created by hj on 2018/11/8.
 */

class MyAdapter<T> extends BaseAdapter {
    private Context mContext;
    private LinkedList<Icon> mData;
    public MyAdapter(LinkedList<Icon> mData,Context mContext){
        this.mContext=mContext;
        this.mData=mData;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(mContext).inflate(R.layout.item_list_icon,parent,false);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.img_icon);
        TextView textView=(TextView)convertView.findViewById(R.id.txt_icon);
        imageView.setBackgroundResource(mData.get(position).getiId());
        textView.setText(mData.get(position).getiName());
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void add(T data){

    }

}
