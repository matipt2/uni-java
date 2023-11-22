public class MicroException extends Exception{
    private String message;
    private int errorLine;

    public MicroException(){

    }
    public MicroException(String message, int errorLine){
        this.message = message;
        this.errorLine = errorLine;
    }
    public String getMessage(){
        return message;
    }

    public int getErrorLine(){
        return errorLine;
    }
}