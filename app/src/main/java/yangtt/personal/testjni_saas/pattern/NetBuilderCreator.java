package yangtt.personal.testjni_saas.pattern;

import yangtt.personal.testjni_saas.util.NetBuilder;

public class NetBuilderCreator {
    public static NetBuilder createBuilder(String className){
        NetBuilder builder=null;
        switch (className){
            case "URLConnection":
                builder=new URLConnectionBuilder();
                break;
            case "OkHttp3":
                builder=new OkHttpBuilder();
                break;
            case "OkHttp2":
                builder=new OkHttp2Builder();
                break;
        }
        return builder;
    }
}
