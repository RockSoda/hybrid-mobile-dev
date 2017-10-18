package week9_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIn {

    FileIn(){ }

    public String in() throws IOException {
        String content = null;
        File file = new File("/Users/sigh/IdeaProjects/JavaFX/File.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            System.out.println("Cannot find information data (named File.txt)! Please try again!");
        } finally {
            if(reader !=null){
                reader.close();
            }
        }
        return content;
    }

}