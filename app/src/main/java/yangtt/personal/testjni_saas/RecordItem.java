package yangtt.personal.testjni_saas;

/**
 * Created by hj on 2018/12/11.
 */

public class RecordItem {
    private String name;
    private String value;
    private int iconResourceId;
    public RecordItem(String name,int iconResourceId){
        this.name=name;
        this.iconResourceId=iconResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
