package yangtt.personal.testjni_saas.util;

public class Crash {
    public static int createJava(String url){
        if(!"".equals(url)){
            OkHttp3Builder builder=new OkHttp3Builder();
            builder.get(url);
        }
        return 1000/0;
    }
    public static int indexOut(int[] array,int index){
        return array[index];
    }
}
