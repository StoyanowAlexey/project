package EmailEnteringProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {

    protected void writeToFileByOneLine(List<String> list, File fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            for (String x : list){
                writer.write(x);
                writer.newLine();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    protected void writeToFileByPersonType(List <Person> personList, File fileName){
        for (Person x : personList){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
                writer.write(x.getName() + " " + x.getAge() + " " + x.getWork()+ " " + x.getPhone());
                writer.newLine();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    protected void clearTheFile(File file) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
