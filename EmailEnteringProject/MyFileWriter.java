package EmailEnteringProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {

    protected void writeToFileLineByLine(List<String> list, int capacity, File fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            for (int i = 0; i < capacity; i++){
                if (list.get(i) != null){
                    //System.out.print(list.get(i));
                    writer.write(list.get(i));
                    //System.out.println();
                    writer.newLine();
                }

            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    protected void writeToFileByPersonType(List <Person> personList, int capacity, File fileName){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                for (int i = 0; i < capacity; i++) {
                    if (personList.get(i) != null){
                        writer.write(personList.get(i).getName() + " " + personList.get(i).getAge() + " " + personList.get(i).getWork() + " " + personList.get(i).getPhone());
                        writer.newLine();
                    }
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
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
