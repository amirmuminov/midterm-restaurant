package kz.muminov.midtermrestaraunt.exception.types;

public class UserNotFoundException extends NullPointerException {

    public UserNotFoundException(){
        super("User with this ID is not found");
    }

}
