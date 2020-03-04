package yangtt.personal.testjni_saas.util;

public abstract class NetBuilder {
    public String url;
    public final String headerKey="myTag";
    public final String headerValue="ytt";
    public NetBuilder url(String url){
        if("".equals(url)){
            throw new NullPointerException("url param is null");
        }
        this.url=url;
        return this;
    }
    public NetBuilder method(String method) {
        switch (method){
            case "get":
                this.get(this.url);
                break;
            case "post":
                this.post(this.url,"");
                break;
            case "put":
                this.get(this.url);
                break;
            case "delete":
                this.get(this.url);
                break;
            case "head":
                this.get(this.url);
                break;
        }
        return this;
    }
    public abstract void get(String url);
    public abstract void post(String url,String body);
}
