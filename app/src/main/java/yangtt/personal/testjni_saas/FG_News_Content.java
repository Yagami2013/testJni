package yangtt.personal.testjni_saas;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Created by hj on 2018/12/20.
 */

public class FG_News_Content extends mBaseFragment {
    public FG_News_Content(){}

    @Override
    public String doSomeThing() {
        return null;
    }

    @Override
    public long getOverLapStart() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_news_content, container, false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_news_content);
        //getArgument获取传递过来的Bundle对象
        txt_content.setText(getArguments().getString("content"));
        return view;
    }
}
