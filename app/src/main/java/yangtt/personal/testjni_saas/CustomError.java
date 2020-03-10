package yangtt.personal.testjni_saas;


import java.util.HashMap;
import java.util.Map;

import yangtt.personal.testjni_saas.util.CustomException;
import yangtt.personal.testjni_saas.util.Tingyun;

public class CustomError {
    String id = ""+System.currentTimeMillis();
    private void anyFunction(String msg) throws CustomException{
        throw new CustomException(msg);
    }
    private void anyFunction() throws Exception{
        throw new Exception();
    }
    public void newCustomException(String msg){
        try {
            this.anyFunction(msg);
        } catch (Exception e){
            Map<String,Object> mData = new HashMap<>();
            mData.put("ErrorID",this.id);
            printStack(e);
            Tingyun.reportException(msg,e,mData);
            LogY.m("reportError with CustomException");
        }
    }
    public void newExcetion(){

        Map<String,Object> mData = new HashMap<>();
        mData.put("ErrorID",this.id);
        newException("error with Exception",mData);
    }
    public void newException(String msg,Map<String,Object> mData){
        try {
            this.anyFunction();
        } catch (Exception e){
            printStack(e);
            Tingyun.reportException(msg,e,mData);
        }
    }
    public void newError(){

        Map<String,Object> mData = new HashMap<>();
        mData.put("ErrorID",this.id);
        Tingyun.reportError("an error",mData);
        LogY.m("reportError without Exception");
    }
    private void printStack(Exception e){
        StackTraceElement[] stacks = e.getStackTrace();
        for (StackTraceElement s:stacks
             ) {
            LogY.m(s.toString());
        }

        }

}
