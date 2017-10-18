package week9_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Merge {
    private static String mail = "";

    Merge(){}

    Merge(String s, Data d) {
        mail = s.replace("<<N>>",d.getName())
                .replace("<<A>>",d.getAge())
                .replace("<<G>>",d.getGender());
    }

    public String getMailString(){
        return mail;
    }

    public String getMail(int personID) throws IOException {
        ArrayList<Data> dataList;
        DataHelper helper = new DataHelper();
        dataList = helper.getDataList();
        Merge m = new Merge(new FileIn().in(), dataList.get(personID));

        return m.getMailString();
    }



}
