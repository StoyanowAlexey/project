package LB5;

public class MyArrayList {
    private Integer [] ar;
    private int size;

    public MyArrayList(int n){
        ar = new Integer[n];
        size = 0;
    }

    public boolean add(Integer n){
        if(size < ar.length){
            ar[size] = n;
            size++;
            return true;
        }
        else return false;
        
    }

    public Integer remove(){
        if(size > 0){
            Integer removed = ar[size - 1];
            ar[size - 1] = null;
            size--;
            return removed;
        }
        return null;
    }

    public String toString(){
        String arrayElements = "";
        for(int i = 0; i < size; i++){
            arrayElements = arrayElements + ar[i] + " ";
        }
        return arrayElements;
    }

    public MyListIterator iterator (){
        return new MyListIteratorImpl();
    }

    private class MyListIteratorImpl implements MyListIterator{


        int cursor;
        int func;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public Integer next() {
            if(hasNext()){
                func = 1;
                cursor++;
                return ar[cursor];
            }
            else return null;
        }

        @Override
        public Integer previous() {
            if(hasPrevious()){
                func = -1;
                cursor--;
                return ar[cursor];
            }
            else return null;

        }

        @Override
        public void set(Integer n) {
              if(func == 1) ar[cursor - 1] = n;
              else if(func == -1) ar[cursor] = n;
              else System.out.println("");
        }

        @Override
        public void remove() {
             if(func != 0 && cursor != 0){
                Integer [] cloneArray = ar.clone();
                ar[size - 1] = null;
                size--;
                for(int i = 0; i < size; i++){
                    if(i == cursor - 1) ar[i] = cloneArray[i + 1];
                }
             }
        }

        @Override
        public int nextIndex() {
            if(hasNext()){
                return cursor;
            }
            else return size;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }
        //0 1 2 3 4 5
        // _
        //0 6 1 2 3 4 5
        @Override
        public void add(Integer n) {
            if (size < ar.length) {
                size++;
                Integer [] cloneArray = ar.clone();
                ar[cursor] = n;
                for(int i = 0; i < size; i++){
                    if(i > cursor) ar[i] = cloneArray[i - 1];
                }
                cursor++;
            }
        }
    }

}
