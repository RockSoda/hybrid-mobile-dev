package week12_1;


public class Appointment extends Entry{
    public String person;
    public String place;

    public Appointment(String date, String person, String place){
        super(date);
        this.person = person;
        this.place = place;
    }

    public String getPerson() {
        return person;
    }

    public String getPlace() {
        return place;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Date: "+date+"\n"+"Person: "+person+"\n"+"Place: "+place+"\n"+"Entered Time: "+getEnteredTime();
    }

}
