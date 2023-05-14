import java.io.*;
import java.util.Scanner;

public class FileProcessing {
    String fileName = "counter.txt";
    File file;

    FileProcessing() {
        try {
            file = new File(fileName);
            if (!file.exists()) file.createNewFile();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void writeToFile(String string) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(string);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Long readFromFile() {
        try {
            Scanner reader = new Scanner(file);
            String str = reader.nextLine();
            return Long.parseLong(str);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}