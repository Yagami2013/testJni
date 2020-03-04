package yangtt.personal.testjni_saas;

/**
 * Created by hj on 2018/11/23.
 */

class SpeakSelf extends Speaker{
    private String text;
    private String bName;
    private String bAuthor;
    public SpeakSelf(String text){this.text=text;}

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}
