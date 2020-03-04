package yangtt.personal.testjni_saas;

import android.widget.ImageView;

/**
 * Created by hj on 2018/12/20.
 */

public class News extends Throwable{
    private String Title;
    private String content;
    private ImageView[] images;
    public News(String Title,String content){
        this.Title=Title;
        this.content=content;
    }
    public News(String Title,String content,ImageView[] images){
        this.Title=Title;
        this.content=content;
        this.images=images;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    /*    public void setContent (String text, int index) throws IndexOutOfBoundsException {
        this.content[index] = text;
    }

    public String getContent() {
        String text="";
        for(int i=0;i<content.length;i++){
            text=text+content[i];
        }
        return text;
    }
    */

    public void setImages(ImageView[] images) {
        this.images = images;
    }
    public void setImages(ImageView image,int index) throws IndexOutOfBoundsException{
        this.images[index]=image;
    }

    public ImageView[] getImages() {
        return images;
    }
}
