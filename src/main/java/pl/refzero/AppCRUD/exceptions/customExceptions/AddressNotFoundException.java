package pl.refzero.AppCRUD.exceptions.customExceptions;

public class AddressNotFoundException extends RuntimeException{

    private static final long serialVersionUID =3;

    public AddressNotFoundException(String message){
        super(message);
    }
}
