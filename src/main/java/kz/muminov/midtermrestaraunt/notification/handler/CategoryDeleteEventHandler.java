package kz.muminov.midtermrestaraunt.notification.handler;

import kz.muminov.midtermrestaraunt.notification.event.CategoryDeleteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CategoryDeleteEventHandler implements ApplicationListener<CategoryDeleteEvent> {

    @Override
    public void onApplicationEvent(CategoryDeleteEvent categoryDeleteEvent) {
        System.out.println("Category with id: " + categoryDeleteEvent.getId() + " was deleted");
    }

}
