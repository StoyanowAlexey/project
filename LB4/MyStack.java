package LB4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class MyStack implements IMyStack {
    private Vector<Double> v = new Vector<>();


    @Override
    public void push(double val) {
        v.add(v.size(),val);
    }

    @Override
    public double pop() {
        return v.remove(v.size() - 1);
    }

    @Override
    public double peek() {
        if(v.size() == 0) {
            System.out.println("Вектор пустий!!!");
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
