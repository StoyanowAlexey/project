package LB4;

import java.util.*;

public class MyQueue implements IMyQueue{
    //Queue<Double> queue = new Queue<Double>()
    private Vector<Double> v = new Vector<Double>();

    @Override
    public void enqueue(double val) {
        v.add(v.size() ,val);
    }

    @Override
    public double dequeue() {
        return v.remove(0);
    }

    @Override
    public double peek() {
        if(v.size() == 0){
            System.out.println("Вектур пустий!!!");
            return 0;
        }
        else return v.get(v.size() - 1);
    }

    @Override
    public int getSize() {
        return v.size();
    }

    @Override
    public void clear() {
         v.clear();
    }
}
