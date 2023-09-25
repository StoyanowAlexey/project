package LB4;

public interface Container {
    void put(double val); //додати елемент
    double get(); //забрати елемент
    double peek();//подивитись елемент (не забирати)
    int getSize();  //кількість елементів в контейнері
    void clear();   //очистити контейнер

}
