package yangtt.personal.testjni_saas.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import yangtt.personal.testjni_saas.LogY;

public class UrlConnectionBuilder extends Builder {
    static URL url;
    static Thread thread;

    public static void request(final String method, final String urlString){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    url = new URL(urlString);
                    final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod(method);
                    connection.setReadTimeout(5 * 1000);
                    connection.setRequestProperty("Accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    long start=System.currentTimeMillis();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    byte[] data = new byte[1024];
                    int responseCode = connection.getResponseCode();
                    LogY.m("request url:" + urlString);
                    LogY.m("response code:" + responseCode);
                    StringBuffer sb=new StringBuffer();
                    //Tingyun catches network perfor-data only when the input stream closed
                    while (inputStream.read(data)!=-1){
                        String str=new String(data, Charset.forName("utf-8"));
                        sb.append(str);
                    }
                    //LogY.m(sb.toString());
                    inputStream.close();
                    connection.disconnect();
                    long end=System.currentTimeMillis();
                    LogY.m("urlconnection request end:"+end);
                    LogY.m("Duration time:"+(end-start)+" ms");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    @Override
    public void get(String urlString){
        request("GET",urlString);
    }
    public void get() {
        get(TestUrls.news);
    }
    @Override
    public  void post(String urlString){
        request("POST",urlString);
    }
    public  void post(){
        post(TestUrls.news);
    }



}
