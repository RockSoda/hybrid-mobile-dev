package week9_1;

import java.io.IOException;
import java.util.ArrayList;

public class CreateMail {
    private static String mail = "";
    private ArrayList<Data> dataList;


    CreateMail(){}

    CreateMail(String s, Data d) {
        mail = s.replace("<<N>>",d.getName())
                .replace("<<A>>",d.getAge())
                .replace("<<G>>",d.getGender());
    }

    public String getMailString(){
        return mail;
    }

    public String getMail(int personID) throws IOException {
        DataHelper helper = new DataHelper();
        dataList = helper.getDataList();
        CreateMail m = new CreateMail(new FileIn().in(), dataList.get(personID));

        return m.getMailString();
    }

    public boolean hasNext(int index){
        if(index+1 == dataList.size()){
            return false;
        }else return true;
    }

    public boolean hasPrevious(int index){
        if(index == 0){
            return false;
        }else return true;
    }



}
