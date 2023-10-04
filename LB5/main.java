package LB5;

public class main {
    public static void main(String [] args){
        MyArrayList ma = new MyArrayList(10);
        ma.add(1);
        ma.add(2);
        ma.add(3);
        System.out.println("Array after using method add() 3 times ");
        System.out.println(ma);
        ma.remove();
        System.out.println("Array after using method remove()   :    " + ma);
        MyListIterator it = ma.iterator();
        System.out.println("Next element (method next() ) -   " + it.next());
        System.out.println("Method nextIndex()   -   "+ it.nextIndex());
        System.out.println("Method previousIndex()  -  " + it.previousIndex());
        System.out.println("Previous element (method previous () )   -   " + it.previous());
        it.previous();
        System.out.println("Testing method previousPrevious() when cursor = 0   " + it.previousIndex());
        it.next();
        System.out.println("Now cursor = 1, testing method add() ");
        it.add(3);
        System.out.println("Array   :   " + ma);
        System.out.println("Now cursor = 2, testing method remove() ");
        it.remove();
        System.out.println("Array   :   " + ma);
        System.out.println("Now cursor = 1, testing method set () ");
        System.out.println("Using method next ()   -   " + it.next());
        it.set(12);
        System.out.println("Array   :   " + ma);
        System.out.println("Using method previous() 2 times, and after method set ()  ");
        it.previous();
        it.previous();
        it.set(34);
        System.out.println("Array   :   " + ma);

    }
}
