package kz.muminov.midtermrestaraunt.notification.event;

import org.springframework.context.ApplicationEvent;

public class StaffDeleteEvent extends ApplicationEvent {

    private Long id;

    public StaffDeleteEvent(Object source, Long id) {
        super(source);
        this.id = id;
    }

    public Long getId(){
        return id;
    }

}
