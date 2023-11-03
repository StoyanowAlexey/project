package Task12;

public class MyWrongIndexException extends Exception {
    String getMessage(int index){
        return "Exception : False index, index = " + index + ".";
    }
}
