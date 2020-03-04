package yangtt.personal.testjni_saas.util;

public class CustomException extends Exception{
    private String msg;

    public CustomException(String msg){
        this.msg = msg;
    }
    @Override
    public String getMessage(){
        String superMsg =super.getMessage();
        if(superMsg==null){return this.msg;}
        if(this.msg==null){return superMsg;}
        this.msg = this.msg + superMsg;
        return this.msg;
    }
}
