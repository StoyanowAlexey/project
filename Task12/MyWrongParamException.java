package Task12;

public class MyWrongParamException extends Exception {
    private String message;
    public MyWrongParamException(int size){
        message = "False capacity " + ", size = " + size;
    }

    public String getMessage(){
        return message;
    }

}
