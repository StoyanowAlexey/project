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

    public String getPhone(){
        return phone;
    }

    public String getName(){
        return name;
    }

    public String getWork(){
        return work;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return " Name - " + name + "\n Age - " + age + "\n Work - " + work + "\n Phone number: " + phone;
    }
}
