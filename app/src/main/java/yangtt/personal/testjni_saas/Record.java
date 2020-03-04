package yangtt.personal.testjni_saas;

import java.util.Date;

/**
 * Created by hj on 2018/12/11.
 */

public class Record {
    private String name;
    private Date recordDay;
    private int resId;
    private boolean value_bool;
    private float vaule_float;
    private String value_String;
    public Record(String name,boolean value_bool,float vaule_float,String value_String){
        this.name=name;
        this.value_bool=value_bool;
        this.vaule_float=vaule_float;
        this.value_String=value_String;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRecordDay(Date recordDay) {
        this.recordDay = recordDay;
    }

    public Date getRecordDay() {
        return recordDay;
    }

    public void setValue_bool(boolean value_bool) {
        this.value_bool = value_bool;
    }
    public boolean getValue_bool(){
        return value_bool;
    }

    public void setVaule_float(float vaule_float) {
        this.vaule_float = vaule_float;
    }
    public float getVaule_float() {
        return vaule_float;
    }
    public void setValue_String(String value_String) {
        this.value_String = value_String;
    }

    public String getValue_String() {
        return value_String;
    }
}
