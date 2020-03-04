package yangtt.personal.testjni_saas.pattern;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import yangtt.personal.testjni_saas.LogY;

class OkHttpBuilder extends yangtt.personal.testjni_saas.util.NetBuilder {
    OkHttpClient client=new OkHttpClient();
    Request request = new Request.Builder()
            .url(url)
            .addHeader(this.headerKey,this.headerValue)
            .build();

    @Override
    public void get(String url){
            try (Response response = client.newCall(request).execute()) {
                LogY.m(url+":"+response.code());
            }catch (IOException e){
                e.printStackTrace();
            }
    }

    @Override
    public void post(String url, String body) {
        request.body();
        OkHttpClient builder=client.newBuilder()
                .readTimeout(5000, TimeUnit.MICROSECONDS)
                .build();
        try {
            Response response=builder.newCall(request).execute();
            LogY.m(url+":"+response.code());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
