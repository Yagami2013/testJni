package yangtt.personal.testjni_saas;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends mBaseActivity{
    Button button_network;
    Button button_UI;
    Button button_crash;
    Button button_record;
    private FG_UI uiFragment;
    private FG_Test networkFragment;
    private FragmentManager fragmentManager;
    private FG_Record recorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_root);

        fragmentManager=getFragmentManager();

        button_network=findViewById(R.id.tab1);
        button_UI=findViewById(R.id.tab2);
        button_crash=findViewById(R.id.tab3);

        FrameLayout frameLayout=(FrameLayout)findViewById(R.id.fg);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                hideAllFragment(transaction);
                    switch (v.getId()){
                        case R.id.tab1:
                            if(networkFragment==null){
                                networkFragment = new FG_Test();
                                transaction.add(R.id.fg,networkFragment);
                            }else {
                                transaction.show(networkFragment);
                            }
                            break;
                        case R.id.tab2:
                            if(uiFragment==null){
                                uiFragment = new FG_UI();
                                transaction.add(R.id.fg,uiFragment);
                            }else {
                                transaction.show(uiFragment);
                            }
                            break;
                        case R.id.tab3:
                            if(networkFragment==null){
                                networkFragment = new FG_Test();
                                transaction.add(R.id.fg,networkFragment);
                            }else {
                                transaction.show(networkFragment);
                            }
                            break;
                    }
                transaction.commit();
                }
        };

        button_network.setOnClickListener(listener);
        button_UI.setOnClickListener(listener);
        button_crash.setOnClickListener(listener);

    }

    @Override
    public void doSomeThing() {

    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(networkFragment != null)fragmentTransaction.hide(networkFragment);
        if(uiFragment != null)fragmentTransaction.hide(uiFragment);
    }
}

