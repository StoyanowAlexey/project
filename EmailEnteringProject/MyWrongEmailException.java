package EmailEnteringProject;

public class MyWrongEmailException extends Exception{
    public String getMessage(){
        return "Error: you write email that existed or fake email ";
    }
}
