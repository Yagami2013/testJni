package yangtt.personal.testjni_saas;

/**
 * Created by hj on 2018/11/23.
 */

class Speaker {
    private String text;
    public Speaker(){}
    public Speaker(String text){
        this.text=text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
