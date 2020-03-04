package yangtt.personal.testjni_saas.pattern;

import android.app.Activity;
import android.os.Bundle;


import yangtt.personal.testjni_saas.util.NetBuilder;

public class NetBuilderDemo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new netThread().start();
    }
    class netThread extends Thread{
        @Override
        public void run() {
            super.run();
            String url="https://www.tingyun.com";
            NetBuilder connector= NetBuilderCreator.createBuilder("URLConnection");
            connector.url(url)
                    .method("get");
            NetBuilder connector2= NetBuilderCreator.createBuilder("OkHttpBuilder");
            connector.url(url)
                    .method("get");
        }
    }
}
