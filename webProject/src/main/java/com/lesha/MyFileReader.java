package com.lesha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyFileReader {
    File filePath;

    MyFileReader(File file){
        filePath = file;
    }

    protected List<Person> readFromFilePersonType(){
        List<Person> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(currentLine);
                String name = null,work = null,phoneNumber = null;
                int age = 0;
                while (tokenizer.hasMoreTokens()) {
                    name = tokenizer.nextToken();
                    age = Integer.parseInt(tokenizer.nextToken());
                    work = tokenizer.nextToken();
                    phoneNumber = tokenizer.nextToken();
                }
                Person person = new Person(name,age,work,phoneNumber);
                list.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected List <String> readFromFileOneLineToList(){
        List <String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                list.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
