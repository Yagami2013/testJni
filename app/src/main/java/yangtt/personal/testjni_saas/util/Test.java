package yangtt.personal.testjni_saas.util;

public class Test {
   private static long appStartTime=0;
   public void setAppStartTime(long time){
       appStartTime=time;
   }
   public long getAppStartTime(){
       return appStartTime;
   }
   public long getDuration(long currentTime){
       return (currentTime-appStartTime);
   }
}
