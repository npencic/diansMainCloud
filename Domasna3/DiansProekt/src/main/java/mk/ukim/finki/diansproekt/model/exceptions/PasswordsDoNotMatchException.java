package mk.ukim.finki.diansproekt.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {
    public PasswordsDoNotMatchException(){
        super("Passwords do not match Exception");
    }
}
