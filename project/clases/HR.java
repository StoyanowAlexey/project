package project.clases;

import project.enums.TypeWork;

public class HR extends Worker {
    public String HR_English_level;
    TypeWork type_work = TypeWork.HR ;

    HR(String name, int age, double salary, double experience){
        this.typeWork = type_work;
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
    }
}
//