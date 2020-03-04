package yangtt.personal.testjni_saas.util;

import android.util.Log;

class UnsupportedException extends Exception{
    String tag="yangtt";
    UnsupportedException(String msg){
        Log.e(tag,msg+" unsupported");
    }
}
