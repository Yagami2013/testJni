package yangtt.personal.testjni_saas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import yangtt.personal.testjni_saas.util.Builder;
import yangtt.personal.testjni_saas.util.HttpClientBuilder;
import yangtt.personal.testjni_saas.util.Ok2Builder;
import yangtt.personal.testjni_saas.util.OkHttp3Builder;
import yangtt.personal.testjni_saas.util.TestUrls;
import yangtt.personal.testjni_saas.util.UrlConnectionBuilder;

public class AC_net extends mBaseActivity {

    /*record another method for initializing ArrayList
    private ArrayList<String> httplibs=new ArrayList<String>(Arrays
    .asList("China","USA","Englan","Indian"));*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_net);

        final EditText input=(EditText)findViewById(R.id.ed_request_url);
        final Spinner httpClass=(Spinner)findViewById(R.id.spinner);
        final Spinner requestMethod=(Spinner)findViewById(R.id.spinner2);
        Button okButton=(Button)findViewById(R.id.btn_ok);
        Button errButton=(Button)findViewById(R.id.btn_http_error);
        Button err901=(Button)findViewById(R.id.err_901_unknown_host);
        /*WebView webView=(WebView)findViewById(R.id.webview_AC_net);*/

        err901.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*record another method for initializing spinner,ugly
        httpClass.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,httplibs));*/
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.reqmethod,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        requestMethod.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,
                R.array.libname,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        httpClass.setAdapter(adapter1);


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=input.getText().toString();
                String reqmethod=(String)requestMethod.getSelectedItem();
                String libname=(String)httpClass.getSelectedItem();
                LogY.m("select:"+libname+","+reqmethod);
                /*Toast.makeText(AC_net.this,
                        "request:"+url+","+libname+","+reqmethod,Toast.LENGTH_LONG).show();*/
                Builder builder = null;
                switch (libname){
                    case "OkHttp3.0":
                        builder=new OkHttp3Builder();
                        break;
                    case "OkHttp2.0":
                        builder=new Ok2Builder();
                        break;
                    case "URLConnection":
                        builder=new UrlConnectionBuilder();
                        break;
                    case "HttpClient":
                        builder=new HttpClientBuilder();
                        break;
                }
                builder.url(url)
                        .method(reqmethod);

            }
        });
        errButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestUrls.test_error();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*OkHttp3Builder builder=new OkHttp3Builder();
        builder.get("https://testerhome.com");*/
    }

    @Override
    public void doSomeThing() {

    }
}
