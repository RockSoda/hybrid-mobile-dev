package week1_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {

    public static void out(String str, String fileName) {

        try {
            File newTextFile = new File("/Users/sigh/Desktop/"+fileName);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(str);
            fw.close();

        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public static String in() throws IOException {
        String content = null;
        File file = new File("/Users/sigh/Desktop/info.in");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            System.out.println("Cannot find information data (named info.in)! Please try again!");
        } finally {
            if(reader !=null){
                reader.close();
            }
        }
        return content;
    }
}