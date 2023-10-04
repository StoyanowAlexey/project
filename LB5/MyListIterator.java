package LB5;

public interface MyListIterator {
    boolean hasNext();

    boolean hasPrevious();

    Integer next();

    Integer previous();

    void set(Integer n);

    void remove();

    int nextIndex();

    int previousIndex();

    void add(Integer n);

}
