package week9_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHelper {
    private ArrayList<Data> dataList = new ArrayList<>();

    DataHelper() throws FileNotFoundException {
        File file = new File("/Users/sigh/IdeaProjects/JavaFX/src/Data.txt");
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            Data data = new Data();
            data.setName(input.next());
            data.setAge(input.next());
            data.setGender(input.next());

            dataList.add(data);
        }

        input.close();
    }

    public ArrayList<Data> getDataList() {
        return dataList;
    }
}
