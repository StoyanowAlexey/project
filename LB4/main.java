package LB4;

public class main {
    public static void main(String [] args){
        System.out.println();
        System.out.println("Використання класу MyQueue!!!!!!!!! ");
        MyQueue queue = new MyQueue();
        queue.enqueue(15);
        queue.enqueue(25);
        queue.enqueue(6.12);
        System.out.println("Перший елемент - " + queue.peek());
        System.out.println("Розмір вектора " + queue.getSize());
        queue.dequeue();
        System.out.println("Перший елемент після видалення " + queue.peek());
        queue.clear();
        System.out.println("Застосування методу clear і вивід першого елементу(елементів нема)");
        System.out.println(queue.peek());



        System.out.println();
        System.out.println();
        System.out.println();




        System.out.println("Використання класу MyStack !!!!!!!!! ");
        MyStack stack = new MyStack();
        stack.push(12.5);
        stack.push(14.1);
        stack.push(29.1);
        System.out.println("Елемент який вийде першим " + stack.peek());
        System.out.println("Розмір масив    -    " + stack.getSize());
        stack.pop();
        System.out.println("Елемент який вийде першим після методу pop() " + stack.peek());
        stack.clear();
        System.out.println("Повне очищення вектору ( метод clear() )");
        System.out.println(stack.peek());

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Використання масиву Container");
        System.out.println("Дії з елементом класу MyQueue2");
        Container [] mas = new Container[2];
        mas[0] = new MyQueue2();
        mas[1] = new MyStack2();
        mas[0].put(12.5);
        mas[0].put(14.5);
        mas[0].put(16.7);
        System.out.println("Елемент який вийде першим " + mas[0].peek());
        System.out.println("Розмір масив    -    " + mas[0].getSize());
        mas[0].get();
        System.out.println("Елемент який вийде першим після методу get() " + mas[0].peek());
        mas[0].clear();
        System.out.println("Повне очищення вектору ( метод clear() )");
        System.out.println(mas[0].peek());
        System.out.println();
        System.out.println();
        System.out.println("Дії з елементом класу MyStack2");
        mas[1].put(12.5);
        mas[1].put(167.5);
        mas[1].put(165.23);
        System.out.println("Елемент який вийде першим " + mas[1].peek());
        System.out.println("Розмір масив    -    " + mas[1].getSize());
        mas[1].get();
        System.out.println("Елемент який вийде першим після методу get() " + mas[1].peek());
        mas[1].clear();
        System.out.println("Повне очищення вектору ( метод clear() )");
        System.out.println(mas[1].peek());

    }
}
