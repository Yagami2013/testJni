package yangtt.personal.testjni_saas.util;

public class TestUrls {
    //有content-length
    public static String qq="http://www.qq.com";
    public static String news="http://www.xinhuanet.com/politics/leaders/2019-03/11/c_1124222229.htm";
    public static String cdata="http://c.data.mob.com/v3/cdata";
    //chunked
    public static String chunk_baike="https://baike.baidu.com/item/动物世界/20242925";

    public static String accross_app="http://192.168.2.41:8080/External_01/";
    public  static String https_jd_param ="https://passport.jd.com/new/login.aspx?ReturnUrl=https%3A%2F%2Fa.jd.com%2F";
    public  static String http_400_param="http://sdktest.com/400.php?ie=UTF-8&wd=APM";
    public  static String https_400_param="https://sdktest.com/400.php?ie=UTF-8&wd=APM";
    public  static String https_baidu_param="https://www.baidu.com/s?ie=UTF-8&wd=sophix";
    public  static String https_baidu="https://www.baidu.com/";
    public  static String http_long_time_response="http://10.128.1.21:8899/tingyun.sh";
    public static String http_meituan="http://www.meituan.com/";
    public static String http_renminwang="http://www.people.com.cn/";
    public static String http_tianya="http://www.tianya.cn/";
    public static String http_404="http://www.tianya.cn/test.html";
    public static String tcp_timeout="https://dc1.networkbench.com";
    public static String sina_IPs="http://news.sina.com";
    public static String sk="http://notice.u51.com/aaa.json?a=1&b=2";
    public static String download="http://10.128.1.21:9990/test.jpg";
    public static String media="http://124.193.120.172/hd.yinyuetai.com/uploads/videos/common/DD560169A31A98F7EC6B24436F264C13.mp4?sc=e1415f38000752ab";
    public static String get_http_errors(String protocal,int statusCode){
        /*String host="192.168.5.77:8081";*/
        String host="sdktest.networkbench.com";
        String url=protocal+"://"+host+"/"+statusCode+".php";
        return url;
    }
    public static String[] test_error(){
        String[] urls={};
        OkHttp3Builder builder=new OkHttp3Builder();
        int[] https_error_code={400,401,402,403,404,405,406,408,409,410,411,412,413,414,415,416,417,
                500,501,502,503,504,505};//407 https请求通过抓包会崩溃
        for (int code:https_error_code
             ) {
            /*String url= TestUrls.get_http_errors("http",code);
            builder.asyncGet(url);
            builder.asyncPost(url);*/
            String url2= TestUrls.get_http_errors("https",code);
            builder.asyncGet(url2);
            builder.asyncPost(url2);
        }
        return urls;
    }
}
