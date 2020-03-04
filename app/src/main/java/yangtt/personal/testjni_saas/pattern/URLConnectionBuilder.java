package yangtt.personal.testjni_saas.pattern;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class URLConnectionBuilder extends yangtt.personal.testjni_saas.util.NetBuilder {
    public HttpURLConnection connection;

    URLConnectionBuilder(){
        URL url = null;
        try {
            url = new URL(this.url);
            connection=(HttpURLConnection)url.openConnection();
            connection.setRequestProperty(this.headerKey,this.headerValue);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void get(String url) {
        try {
            int code=connection.getResponseCode();
            if(code==200){
                InputStream is=connection.getInputStream();
                while (is.read()!=-1){
                    is.read();
                }
                is.close();
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void post(String url,String body) {
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

    }
}
