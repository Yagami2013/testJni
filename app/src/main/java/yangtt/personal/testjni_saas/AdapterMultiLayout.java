package yangtt.personal.testjni_saas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hj on 2018/11/27.
 */

public class AdapterMultiLayout extends BaseAdapter {
    private String TAG="ytt";
    private static final int Left=0;
    private static final int Right=1;
    private Context mContext;
    private ArrayList<Object> mData = null;
    public AdapterMultiLayout(Context mContext, ArrayList<Object> mData){
        this.mContext=mContext;
        this.mData=mData;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof SpeakOther) {
            return Left;
        } else if (mData.get(position) instanceof SpeakSelf) {
            return Right;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type=getItemViewType(position);
        ViewHolder1 holder1=null;
        ViewHolder2 holder2=null;
        if(convertView==null){
            switch (type){
                case Left:
                    holder1=new ViewHolder1();
                    convertView= LayoutInflater.from(mContext).inflate(R.layout.item_chat_left,parent,false);
                    holder1.textView=(TextView) convertView.findViewById(R.id.txt_left);
                    convertView.setTag(R.id.Tag_Left,holder1);
                    break;
                case Right:
                    holder2=new ViewHolder2();
                    convertView= LayoutInflater.from(mContext).inflate(R.layout.item_chat_right,parent,false);
                    holder2.textView=(TextView) convertView.findViewById(R.id.txt_right);
                    convertView.setTag(R.id.Tag_Right,holder2);
                    break;
            }
        }else {
            switch (type){
                case Left:
                    holder1=(ViewHolder1)convertView.getTag(R.id.Tag_Left);
                    break;
                case Right:
                    holder2=(ViewHolder2)convertView.getTag(R.id.Tag_Right);
                    break;
            }
        }
        Object object=mData.get(position);
        switch (type){
            case Left:
                SpeakOther other_said=(SpeakOther)object;
                if(other_said!=null){
                    holder1.textView.setText(other_said.getText());
                }
                break;
            case Right:
                SpeakSelf my_said=(SpeakSelf)object;
                if(my_said!=null){
                    holder2.textView.setText(my_said.getText());
                }
                break;
        }
        return convertView;
    }

    private class ViewHolder1 {
        TextView textView;
    }

    private class ViewHolder2 {
        TextView textView;
    }
}
