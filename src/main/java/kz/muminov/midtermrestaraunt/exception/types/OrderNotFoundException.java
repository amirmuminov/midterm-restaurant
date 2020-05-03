package kz.muminov.midtermrestaraunt.exception.types;

public class OrderNotFoundException extends NullPointerException {

    public OrderNotFoundException(){
        super("Order with this ID is not found");
    }

}
