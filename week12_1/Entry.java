package week12_1;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Entry {
    public String date;
    public String enteredTime;
    boolean isLocked = false;

    public Entry(String date){
        this.date = date;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date time = new Date();
        this.enteredTime = dateFormat.format(time);
    }

    public String getEnteredTime() {
        return enteredTime;
    }

    public String getDate() {
        return date;
    }

    public boolean getLock(){
        return isLocked;
    }

    public void setLock(boolean locked) {
        isLocked = locked;
    }
}
