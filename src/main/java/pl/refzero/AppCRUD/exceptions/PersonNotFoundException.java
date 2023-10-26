package pl.refzero.AppCRUD.exceptions;

public class PersonNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1;

    public PersonNotFoundException(String message){
        super(message);
    }
}
