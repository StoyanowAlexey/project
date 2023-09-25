package LB4;

public class MyQueue2 implements Container{
    MyQueue queue = new MyQueue();

    @Override
    public void put(double val) {
        queue.enqueue(val);
    }

    @Override
    public double get() {
        return queue.dequeue();
    }

    @Override
    public double peek() {
        return queue.peek();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
