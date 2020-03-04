package yangtt.personal.testjni_saas;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class SV_PrintLog extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogY.m("service on bind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogY.m("service on create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogY.m("service on startCommand");
        LogY.wait(6);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogY.m("service on Destroy");
        super.onDestroy();
    }
}
