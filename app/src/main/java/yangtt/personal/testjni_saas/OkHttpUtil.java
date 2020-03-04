package yangtt.personal.testjni_saas;

/**
 * Created by hj on 2018/10/23.
 */
import java.io.IOException;

/*import com.okhttp3.Call;
import com.okhttp3.Callback;
import com.okhttp3.OkHttpClient;
import com.okhttp3.Request;
import com.okhttp3.Response;*/
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil{
    private static OkHttpClient client=new OkHttpClient();
    public static int get(String url){
        int responseCode=200;
        Request request=new Request.Builder().url(url).build();
        try {
            Response response=client.newCall(request).execute();
            responseCode=response.code();
        }catch (IOException e){
            e.printStackTrace();
        }
        return responseCode;
    }
    public static void asyncGet(String[] urls){
        for(int i=0;i<urls.length;i++) {

            Request request=new Request.Builder().url(urls[i]).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogY.m("response code:"+response.code());
                    }
                });
        }
    }
}
