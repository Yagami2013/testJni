package yangtt.personal.testjni_saas.util;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;
@SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})

public class JsInterface {
    @JavascriptInterface
    public String getString(){
        return "Hello JS";
    }
}
