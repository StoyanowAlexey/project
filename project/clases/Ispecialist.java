package project.clases;

import project.enums.TypeWork;

public class Ispecialist extends Worker {
    public String [] it_languages;
    public String ispecialist_it_level;
    public String ispecialist_English_level;
    TypeWork type_work = TypeWork.Ispecialist;

    Ispecialist(String name, int age, double salary, double experience){
       this.typeWork = type_work;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.experience = experience;
    }

}
//