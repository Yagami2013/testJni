package yangtt.personal.testjni_saas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hj on 2019/1/22.
 */

public class DBInitializer extends SQLiteOpenHelper {
    public DBInitializer(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,"TestJni.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE record_health(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20)," +
                "height REAL,weight REAL,head_size REAL,poo_count INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
