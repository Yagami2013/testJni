package yangtt.personal.testjni_saas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hj on 2019/1/22.
 */

public class HealthRecord {
    private int id;
    private String name;
    private long date;
    private float hight;
    private float weight;
    private float headSize;
    private int PooCount;
    private SQLiteDatabase db;
    public HealthRecord(long date,float hight,float weight,float headSize,int pooCount){
        this.date=date;
        this.hight=hight;
        this.weight=weight;
        this.headSize=headSize;
        this.PooCount=pooCount;
    }
    public void save(){
        //db.insert("record_health","",{this.date,this.hight,this.weight,this.headSize,this.PooCount});
    }
    public void databaseInit(Context context){
        DBInitializer initializer=new DBInitializer(context,"yangtt.db",null,1){};
        db=initializer.getWritableDatabase();
    }
    public HealthRecord(long date){
        this.date=date;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setHeadSize(float headSize) {
        this.headSize = headSize;
    }

    public void setHight(float hight) {
        this.hight = hight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPooCount(int pooCount) {
        PooCount = pooCount;
    }

    public String getName() {
        return name;
    }

    public float getHeadSize() {
        return headSize;
    }

    public float getHight() {
        return hight;
    }

    public float getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public int getPooCount() {
        return PooCount;
    }

    public long getDate() {
        return date;
    }
}
