package yangtt.personal.testjni_saas;

import android.os.Bundle;

import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import yangtt.personal.testjni_saas.util.JsInterface;
import yangtt.personal.testjni_saas.util.Tingyun;
import yangtt.personal.testjni_saas.LogY;
/**
 * Created by hj on 2019/1/17.
 */

public class AC_Webview extends mBaseActivity {
    private EditText input;
    private Button requestButton;
    private WebView webView;
    private long exitTime=0;
    private long start=0;
    private boolean isOnCreate=false;
    @Override
    public void doSomeThing() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        start=System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        isOnCreate=true;

        input=(EditText)findViewById(R.id.edit_url);
        requestButton=(Button)findViewById(R.id.btn_request_url);
        webView=(WebView)findViewById(R.id.web);

        webView.addJavascriptInterface(new JsInterface(),"AndroidString");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                LogY.m(getLocalClassName()+" Duration:"+(System.currentTimeMillis()-start));
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                super.onConsoleMessage(message,lineNumber,sourceID);
                LogY.m(message + "@"+sourceID+"("+lineNumber+")");
            }
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Tingyun.embedWebview(view,newProgress);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        //String url=input.getText().toString();
        String url="file:///android_asset/index.html";
        WebView.setWebContentsDebuggingEnabled(true);
        webView.loadUrl(url);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=input.getText().toString();
                webView.loadUrl(url);
                start=System.currentTimeMillis();
            }
        });
    }
    //我们需要重写回退按钮的时间,当用户点击回退按钮：
    //1.webView.canGoBack()判断网页是否能后退,可以则goback()
    //2.如果不可以连续点击两次退出App,否则弹出提示Toast
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!isOnCreate){
            start=System.currentTimeMillis();
        }
        isOnCreate=false;
    }
}
