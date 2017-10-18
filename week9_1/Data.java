package week9_1;

public class Data {
    private String name;
    private String age;
    private String gender;

    Data(){
        name = "";
        age = "";
        gender = "";
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

}
