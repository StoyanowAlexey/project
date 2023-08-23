package project.clases;

import project.enums.TypeWork;

public class Recruiter extends Worker{
    public String Recruiter_English_level;
    public int average_number_hired_workers_per_month;
    public double average_number_interviews_per_month;
    public TypeWork type_work = TypeWork.Recruiter;

    Recruiter(String name, int age, double salary, double experience){
        this.typeWork = type_work;
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
    }
}
//