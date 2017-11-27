package week12_1;

import java.io.Serializable;

public class ToDo extends Entry{
    public String description;
    public String due;

    public ToDo(String date, String description, String due){
        super(date);
        this.description = description;
        this.due = due;
    }


    public String getDescription() {
        return description;
    }

    public Serializable getDue() {
        return due;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDue(String due) {
        this.due = due;
    }
    @Override
    public String toString() {
        return "Date: "+date+"\n"+"description: "+description+"\n"+"due date: "+due+"\n"+"Entered Time: "+getEnteredTime();
    }
}
