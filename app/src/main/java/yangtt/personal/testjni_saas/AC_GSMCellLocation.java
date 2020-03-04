package yangtt.personal.testjni_saas;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class AC_GSMCellLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cell);

        Button button = (Button) findViewById(R.id.btn_getCellInfo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String operator = telephonyManager.getNetworkOperator();
                LogY.m("cellInfo:" + operator);
                if(operator.length()>3){
                    int mcc = Integer.parseInt(operator.substring(0, 3));
                    int mnc = Integer.parseInt(operator.substring(3));
                    LogY.m("mobile_country_code:"+mcc);
                    LogY.m("mobile_network_code:"+mnc);
                }


                if (ActivityCompat.checkSelfPermission(AC_GSMCellLocation.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(AC_GSMCellLocation.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                GsmCellLocation location = (GsmCellLocation) telephonyManager.getCellLocation();
                int lac = location.getLac();
                int cid = location.getCid();


                LogY.m("location_area_code:"+lac);
                LogY.m("cell_id:"+cid);

            }
        });
    }


}
