package yangtt.personal.testjni_saas;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by hj on 2018/11/19.
 */

public abstract class AdapterBase<T> extends BaseAdapter {
    private ArrayList<T> mData;
    private int mLayoutRes;
    private static final int Left=0;
    private static final int Right=1;

    public AdapterBase(){

    }
    public AdapterBase(ArrayList<T> mData, int mLayoutRes){
        this.mData=mData;
        this.mLayoutRes=mLayoutRes;
    }
    @Override
    public int getCount() {
        return mData!=null?mData.size():0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=ViewHolder.bind(parent.getContext(),convertView,parent,mLayoutRes,position);
        bindView(holder,getItem(position));
        return holder.getItemView();
    }
    public abstract void bindView(ViewHolder holder,T obj);

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void add(T data){
        if(mData==null){
            mData=new ArrayList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }
    public void add(int position,T data){
        if(mData==null){
            mData=new ArrayList<>();
        }else {
            mData.add(position,data);
            notifyDataSetChanged();//工作原理？
        }
    }
    public void remove(T data){
        if(mData!=null){
            mData.remove(data);
        }
        notifyDataSetChanged();
    }
    public void remove(int position){
        if(mData!=null){
            mData.remove(position);
        }
        notifyDataSetChanged();
    }
    public void clear() {
        if(mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
