package yangtt.personal.testjni_saas;

import android.os.Bundle;


import yangtt.personal.testjni_saas.util.ButtonList;

/**
 * Created by hj on 2018/12/26.
 */

public class AC_TestButtons extends mBaseActivity{
    private CustomError error = new CustomError();
    public void get101Error(){
        for(int i=0;i<101;i++){
            this.error.newError();
        }
    }
    public void getError(){
        this.error.newError();
    }
    public void getException(){
        this.error.newExcetion();
    }
    public void getCustomException(String msg){
        this.error.newCustomException(msg);
    }
    public void testMsg(){
        String msg = "ho ho ho~";
        getCustomException(msg);
    }
    public void testLongMsg(){
        String msg = "s";
        for(int i=0;i<1023;i++){
            msg=msg+"0";
        }
        msg=msg+"e";
        getCustomException(msg);
    }
    public void testSpecialMsg(){
        String msg = "￥$@%*!";
        getCustomException(msg);
    }
    public void testNullMsg(){
        String msg = null;
        getCustomException(msg);
    }
    public void testNullMeta(){
        this.error.newException(null,null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_buttons);


        ButtonList list=new ButtonList(this);
        try {
            list.initButton(R.id.create_101_errors,"get101Error");
            list.initButton(R.id.btn_test_error,"getError");
            list.initButton(R.id.btn_test_exception,"getException");
            list.initButton(R.id.btn_test_custom_exception,"testMsg");
            list.initButton(R.id.create_long_msg,"testLongMsg");
            list.initButton(R.id.create_special_msg,"testSpecialMsg");
            list.initButton(R.id.create_null_msg,"testNullMsg");
            list.initButton(R.id.create_null_metaData,"testNullMeta");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        testMsg();
        super.onPause();
    }

    @Override
    protected void onResume() {
        getError();
        super.onResume();
    }

    @Override
    public void doSomeThing() {

    }
}
