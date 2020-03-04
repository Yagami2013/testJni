package yangtt.personal.testjni_saas.util;

import yangtt.personal.testjni_saas.LogY;

public abstract class Builder {
    /*调用顺序：Builder.url()
                        .method()
                        .build()
    * */
    private String method;
    private String url;
    /*Builder builder=null;
    public Builder libName(String libName){
        switch (libName){
            case "OkHttp3":
                builder=new OkHttp3Builder();
                break;
            case "OkHttp2":
                builder=new Ok2Builder();
                break;
            case "UrlConnection":
                builder=new UrlConnectionBuilder();
                break;
            case "HttpClient":
                builder=new HttpClientBuilder();
                break;

            default:
                builder=new OkHttp3Builder();
                break;
        }
        return builder;
    }*/

    public Builder method(String method){
        switch (method){
            case "Get":
                LogY.m(url);
                this.get(url);
                break;
            case "Post":
                this.post(url);
                break;
            default:
                this.get(url);
                break;
        }
        return this;
    }

    public Builder url(String url){
        this.url=url;
        return this;
    }
    public abstract void get(String url);
    public abstract void post(String url);

}
