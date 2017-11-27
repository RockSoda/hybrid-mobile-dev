package week12_1;


public class Memo extends Entry{
    public String text;

    public Memo(String date, String text){
        super(date);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Date: "+date+"\n"+"Text: "+text+"\n"+"Entered Time: "+getEnteredTime();
    }
}
