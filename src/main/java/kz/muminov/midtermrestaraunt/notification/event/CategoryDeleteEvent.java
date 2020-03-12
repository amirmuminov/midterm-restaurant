package kz.muminov.midtermrestaraunt.notification.event;

import org.springframework.context.ApplicationEvent;

public class CategoryDeleteEvent extends ApplicationEvent {

    private Long id;

    public CategoryDeleteEvent(Object source, Long id) {
        super(source);
        this.id = id;
    }

    public Long getId(){
        return id;
    }

}
