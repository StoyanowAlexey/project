package EmailEnteringProject;

public class Person {
    private int age;
    private String name;
    private String work;
    private String phone;

    Person(String name, int age, String work, String phone){
        this.age = age;
        this.name = name;
        this.work = work;
        this.phone = phone;
    }

    private String getPhone(){
        return phone;
    }

    private String getName(){
        return name;
    }

    private String getWork(){
        return work;
    }

    private int getAge(){
        return age;
    }

    public String toString(){
        return " Name - " + name + "\n Age - " + age + "\n Work - " + work + "\n Phone number: " + phone;
    }
}
