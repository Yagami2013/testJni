package yangtt.personal.testjni_saas;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import yangtt.personal.testjni_saas.util.OkHttp3Builder;
import yangtt.personal.testjni_saas.util.Test;
import yangtt.personal.testjni_saas.util.TestUrls;
import yangtt.personal.testjni_saas.util.Tingyun;

public class MainActivity2 extends mBaseActivity implements RadioGroup.OnCheckedChangeListener{

    private FG_UI uiFragment;
    private FG_Test fg_test;
    private FragmentManager fragmentManager;
    private FG_Record recordFragment;

    private RadioGroup rg_tab_bar;
    private RadioButton rb_record;

    public Bundle argumentsSender;

    private final int REQUEST_WRITE_EXTERNAL_STORAGE=1;
    private void checkPermission() {
        //检查权限（NEED_PERMISSION）是否被授权 PackageManager.PERMISSION_GRANTED表示同意授权
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED//安卓Q
                &&ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

            //用户已经拒绝过一次，再次弹出权限申请对话框需要给用户一个解释
            /*if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission
                    .WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "请开通相关权限，否则无法正常使用本应用！", Toast.LENGTH_SHORT).show();

            }*/
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.READ_PHONE_STATE
            }, REQUEST_WRITE_EXTERNAL_STORAGE);

        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        /*switch (requestCode) {
            case REQUEST_WRITE_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {
                    Toast.makeText(this, "授权成功！", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "onRequestPermissionsResult", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }*/
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        new Thread(new Runnable() {
            @Override
            public void run() {
//                OkHttp3Builder builder=new OkHttp3Builder();
//                builder.get(TestUrls.chunk_baike);
                int responseCode=OkHttpUtil.get(TestUrls.chunk_baike);
                LogY.m("response code:"+responseCode);
                /*String[] urls=getRequestUrl();
                OkHttpUtil.asyncGet(urls);*/
            }
        }).start();
        //Tingyun.init(getApplicationContext());

        checkPermission();
        long onCreateStart=System.currentTimeMillis();
        argumentsSender=new Bundle();
        argumentsSender.putLong("start",onCreateStart);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragmentManager=getFragmentManager();
        rg_tab_bar=(RadioGroup)findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
//获取第一个单选按钮，并设置其为选中状态
        rb_record = (RadioButton) findViewById(R.id.rb_record);
        rb_record.setChecked(true);
    }

    @Override
    public void doSomeThing() {
        LogY.t(getLocalClassName()+" doSomeThing run");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Tingyun.setAppStartEnd(AC_Splash.class.getName());
        LogY.m(""+new Test().getDuration(System.currentTimeMillis()));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId){
            case R.id.rb_network:
                if(fg_test ==null){
                    fg_test = new FG_Test();
                    transaction.add(R.id.fg_content, fg_test);
                }else {
                    transaction.show(fg_test);
                }
                fg_test.setArguments(argumentsSender);
                break;
            case R.id.rb_ui:
                if(uiFragment==null){
                    uiFragment = new FG_UI();
                    transaction.add(R.id.fg_content,uiFragment);
                }else {
                    transaction.show(uiFragment);
                }
                uiFragment.setArguments(argumentsSender);
                break;
            case R.id.rb_record:
                if(recordFragment==null){
                    recordFragment = new FG_Record();
                    recordFragment.setContent("佳俊");
                    transaction.add(R.id.fg_content,recordFragment);
                }else {
                    transaction.show(recordFragment);
                }
                recordFragment.setArguments(argumentsSender);
                break;
/*            case R.id.rb_setting:
                if(fg_test ==null){
                    fg_test = new FG_Network();
                    transaction.add(R.id.fg_content, fg_test);
                }else {
                    transaction.show(fg_test);
                }
                break;*/
        }
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Tingyun.setAppStartEnd(AC_Splash.class.getName());
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg_test != null)fragmentTransaction.hide(fg_test);
        if(uiFragment != null)fragmentTransaction.hide(uiFragment);
        if(recordFragment != null)fragmentTransaction.hide(recordFragment);
    }
}

