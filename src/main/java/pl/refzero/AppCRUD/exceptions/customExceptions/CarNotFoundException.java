package pl.refzero.AppCRUD.exceptions.customExceptions;

public class CarNotFoundException extends RuntimeException{

    private static final long serialVersionUID =2;

    public CarNotFoundException(String message){
        super(message);
    }
}
