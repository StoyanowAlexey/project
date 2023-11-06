package Task12;

public class MySimpleContainer {
    private int [] array;
    private int index;

    MySimpleContainer(int capacity){
        array = new int [capacity];
    }

    public String toString(){
        StringBuilder printArray = new StringBuilder(" ");
        for (int j : array) {
            printArray.append(j).append(" ");
        }
        return printArray.toString();
    }

    public int size(){
        int size = 0;
        for (int j : array) {
            if (j != 0) size++;
        }
        return size;
    }

    public int get(int index){
        return array[index];
    }

    public int set(int index, int newValue){
        int oldValue = array[index];
        array[index] = newValue;
        return oldValue;
    }

    public void add(int newValue){
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] == 0) {
                index = i;
            }
        }
        this.index = index;
        array[index] = newValue;
    }

    public int remove(){
        int removeValue;
        removeValue = array[index];
        array[index] = 0;
        return removeValue;
    }

}
