import java.io.*;
import java.util.Scanner;

public class FileRW {
    private final String fileName = "counter.txt";
    private File file;
    FileRW() throws Exception{
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                writeToFile(0);//write initial value to file
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());//File creation error
            throw ex;
        }
    }
    public void writeToFile(long value) throws Exception{
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(String.valueOf(value));
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//File recording error
            throw ex;
        }
    }
    public long readFromFile() throws Exception{
        String counterValue;
        try {
            Scanner reader = new Scanner(file);
            counterValue = reader.nextLine();
            return Long.parseLong(counterValue);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Empty file or File not found Exception
            throw ex;
        }
    }
}