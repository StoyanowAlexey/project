package LB4;

public interface IMyStack {
    void push(double val); //додати елемент в кінець стеку
    double pop();  //забрати елемент з кінця стеку
    double peek();//подивитись на кінець стеку(не забирати)
    int getSize(); //кількість елементів в стеку
    void clear();  //очистити стек

}
