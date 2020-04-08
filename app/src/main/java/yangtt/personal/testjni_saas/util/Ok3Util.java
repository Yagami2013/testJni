package yangtt.personal.testjni_saas.util;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import yangtt.personal.testjni_saas.LogY;

public class Ok3Util {

    //    public static String TAG = MyApp.TAG;
    public final static int CONNECT_TIMEOUT = 20;
    public final static int READ_TIMEOUT = 10;
    public final static int WRITE_TIMEOUT = 5;
    private static OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
            .addInterceptor(new RetryIntercepter(3))
//            .addInterceptor(new com.networkbench.agent.impl.h.b())
            .build();


    private Handler mHandler = new Handler(Looper.getMainLooper());




    public static void timeOut(String url,int ms){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(ms, TimeUnit.MILLISECONDS)
                .readTimeout(ms, TimeUnit.MILLISECONDS)
                .writeTimeout(ms, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }


    public static void okHttpPostZhiHuVersion() {
        String url = "http://news-at.zhihu.com/api/4/version/android/2.3.0";
        FormBody.Builder params = new FormBody.Builder();
        params.add("e", "0");
        params.add("f", "2");
        RequestBody body = params.build();
        final Request request = new Request.Builder().url(url).post(body).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onResponse(Call arg0, Response response) {

            }

            @Override
            public void onFailure(Call arg0, IOException arg1) {

            }
        });
    }




    /**
     * okHttp 同步Get数据
     *
     * @param url
     * @return
     */
    public static String syncOkHttpGet(String url) {
        Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
//            response.toString();
            response.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
//        Request request = new Request.Builder().url(url).build();
//        try {
//            Log.e(TAG, "okHttpGet_nostream: Start" + (System.currentTimeMillis() - MyApp.attachBaseStart) );
//            Response response = mOkHttpClient.newCall(request).execute();
//            response.close();

//            if (response.isSuccessful()) {
//                Log.e(TAG, "okHttpGet_nostream: End" + (System.currentTimeMillis() - MyApp.attachBaseStart) );
//                response.close();
////                return response.body().string();
//                return "1";
//            }else {
//                response.close();
//                return "response not successful";
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.e(TAG, "okHttpGet_nostream: End" + (System.currentTimeMillis() - MyApp.attachBaseStart) );
//        return "response not successful";
    }

    /**
     * okHttp 同步Post数据
     *
     * @param url
     * @return
     */
    public static void syncOkHttpPost(String url) {
        FormBody.Builder params = new FormBody.Builder();
        params.add("e", "0");
        params.add("f", "2");
        RequestBody body = params.build();
        final Request request = new Request.Builder().url(url).post(body).build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * okhttp 异步Get数据
     *
     * @param url
     * @return
     */
    public static void okHttpGet_nostream(final String url) {
        Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call arg0, Response response) throws IOException {
                response.close();
                if (null == response.body()){
                    LogY.m("response.body() = null");
                }else {
                    String hd=response.header("Content-Length");
                    long cl=response.body().contentLength();
                    LogY.m( "response.body().contentLength() = " + hd);
                }
//                InputStream is = response.body().byteStream();
//                if (is != null) {
//                    byte[] buffer = new byte[1024];
//                    int len;
//                    StringBuilder sb = new StringBuilder();
//                    while ((len = is.read(buffer)) > 0) {
//                        sb.append(len);
//                    }
//                    is.close();
//                }
            }
            @Override
            public void onFailure(Call arg0, IOException arg1) {

            }
        });
    }

    public interface Finish{
        void onFinish();

    }




    public static void okHttpGet(final String url, final Finish f) {
        Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call arg0, Response response) throws IOException {
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
                f.onFinish();
            }
            @Override
            public void onFailure(Call arg0, IOException arg1) {
                f.onFinish();
            }
        });
    }


    /**
     * okhttp 异步Post数据
     *
     * @param url
     * @return
     */
    public static void okHttpPost(String url) {
        FormBody.Builder params = new FormBody.Builder();
        params.add("e", "0");
        params.add("f", "2");
        RequestBody body = params.build();
        Request request = new Request.Builder().post(body).url(url).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call arg0, Response response) throws IOException {
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
            }

            @Override
            public void onFailure(Call arg0, IOException arg1) {

            }
        });
    }
}

/**
 * 重试拦截器
 */
class RetryIntercepter implements Interceptor {

    public int maxRetry;//最大重试次数
    private int retryNum = 0;//假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）

    public RetryIntercepter(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Response response = chain.proceed(request);

        while (!response.isSuccessful() && retryNum < maxRetry) {
            retryNum++;
            response = chain.proceed(request);
        }
        return response;
    }
}

class Taici {

//	{
//	    "id": "192",
//	    "taici": "即使相处的时间不多，但所谓的友情是不在乎相处的时间长短的。",
//	    "cat": "a",
//	    "catcn": "动画",
//	    "show": null,
//	    "source": "海贼王"
//	}

    private String id;
    private String taici;
    private String cat;
    private String catcn;
    private String show;
    private String source;

    public Taici(String id, String taici, String cat, String catcn,
                 String show, String source) {
        super();
        this.id = id;
        this.taici = taici;
        this.cat = cat;
        this.catcn = catcn;
        this.show = show;
        this.source = source;
    }

    public Taici() {
        super();
    }

    @Override
    public String toString() {
        return "Taici [id=" + id + ", taici=" + taici + ", cat=" + cat
                + ", catcn=" + catcn + ", show=" + show + ", source=" + source
                + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaici() {
        return taici;
    }

    public void setTaici(String taici) {
        this.taici = taici;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCatcn() {
        return catcn;
    }

    public void setCatcn(String catcn) {
        this.catcn = catcn;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


}


