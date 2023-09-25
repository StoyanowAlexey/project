package LB4;

public class MyStack2 implements Container{
    MyStack stack = new MyStack();
    @Override
    public void put(double val) {
         stack.push(val);
    }

    @Override
    public double get() {
        return stack.pop();
    }

    @Override
    public double peek() {
        return stack.peek();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public void clear() {
         stack.clear();
    }
}
