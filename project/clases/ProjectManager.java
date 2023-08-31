package project.clases;

import project.enums.TypeWork;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class ProjectManager extends Worker{
    Map<String, LocalDateTime> calendar;
    TypeWork type_work = TypeWork.ProjectManager;

    ArrayList<String> projects = new ArrayList<String>();
    ProjectManager(String name, int age, double experience, double salary){
        this.typeWork = type_work;
        this.age = age;
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }
    

}
