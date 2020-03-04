package yangtt.personal.testjni_saas;

/**
 * Created by hj on 2018/11/23.
 */

class SpeakOther extends Speaker{
    private String text;
    private String aName;
    private int aIcon;
    public SpeakOther(String text){this.text=text;}

    public int getaIcon() {
        return aIcon;
    }

    public String getaName() {
        return aName;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
