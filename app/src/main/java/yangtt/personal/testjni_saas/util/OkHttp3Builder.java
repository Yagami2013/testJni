package yangtt.personal.testjni_saas.util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*import com.okhttp3.Call;
import com.okhttp3.Callback;
import com.okhttp3.OkHttpClient;
import com.okhttp3.Request;
import com.okhttp3.Response;*/
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import yangtt.personal.testjni_saas.LogY;
import yangtt.personal.testjni_saas.R;

public class OkHttp3Builder extends Builder {
//public class OkHttp3Builder{
    String defaultUrl=TestUrls.https_baidu_param;

    public final static int CONNECT_TIMEOUT = 10;
    public final static int READ_TIMEOUT = 5;
    public final static int WRITE_TIMEOUT = 5;
    //OkHttpClient client=new OkHttpClient.Builder()
    OkHttpClient client=new OkHttpClient().newBuilder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
            .build();

    @Override
    public void get(final String url){
        final long begin = System.currentTimeMillis();
        Request request=new Request.Builder()
                .url(url)
                .addHeader("yttTag","cql")
                .get()
                .build();

        final Call call=client.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //call.execute();

                    //test no response in context

                    Response response=call.execute();
                    InputStream inputStream=response.body().byteStream();
                    if(inputStream!=null){
                        byte[] buffer = new byte[1024];
                        int len;
                        StringBuffer sb=new StringBuffer();
                        while ((len=inputStream.read(buffer))>0){
                            sb.append(len);
                        }
                        inputStream.close();
                        long end=System.currentTimeMillis();
                        LogY.m("request:"+url+" coasts "+(end-begin)+" ms，code:"+response.code());
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void post(String url) {
        post(null,url);
    }

    public void post(Map<String,String> form,String url) {
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), "/sdcard/NBS/web.jpg");
        //RequestBody requestBody = new MultipartBody.Builder()
        MultipartBody.Builder builder=new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "head_img", fileBody);
        if(form!=null){
            for (String body:form.keySet()
            ) {
                builder.addFormDataPart(body,form.get(body));
            }
        }

        RequestBody requestBody=builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
        });
    }

    public void get(){
        get(defaultUrl);
    }
    public void asyncGet(final String url){
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = client.newCall(request);
        LogY.m("request:"+url);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogY.m( url+ " Fail:"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogY.m(url+" response code:"+response.code());
                InputStream is = response.body().byteStream();
                if (is != null) {
                    byte[] buffer = new byte[1024];
                    int len;
                    StringBuilder sb = new StringBuilder();
                    while ((len = is.read(buffer)) > 0) {
                        sb.append(len);
                    }
                    is.close();
                }
                //LogY.m( "OkHttp responsed " + response.code()+" at:"+System.currentTimeMillis() );
            }
        });
    }
    public void asyncGet(){
        asyncGet(defaultUrl);
        asyncGet(TestUrls.news);
        asyncGet(TestUrls.http_400_param);
        asyncGet(TestUrls.https_jd_param);
        asyncGet(TestUrls.https_baidu);
        asyncGet(TestUrls.sina_IPs);
        //asyncGet(TestUrls.tcp_timeout);
    }
    public void asyncPost(final String url){
        String params="yttTag:cql";
        RequestBody body=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),params);
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        LogY.m("request:"+url);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogY.m( url+ " Fail:"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogY.m(url+" response code:"+response.code());
                //LogY.m( "OkHttp responsed " + response.code()+" at:"+System.currentTimeMillis() );
            }
        });
    }

}
