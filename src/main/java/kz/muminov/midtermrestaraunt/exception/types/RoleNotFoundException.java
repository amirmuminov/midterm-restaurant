package kz.muminov.midtermrestaraunt.exception.types;

public class RoleNotFoundException extends NullPointerException {

    public RoleNotFoundException(Long id){
        super("Role with ID " + id + " is not found");
    }

}
