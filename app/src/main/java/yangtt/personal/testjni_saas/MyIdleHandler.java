package yangtt.personal.testjni_saas;

import android.os.MessageQueue;

/**
 * Created by hj on 2019/1/14.
 */

public class MyIdleHandler implements MessageQueue.IdleHandler {
    @Override
    public boolean queueIdle() {
        return false;
    }
}
