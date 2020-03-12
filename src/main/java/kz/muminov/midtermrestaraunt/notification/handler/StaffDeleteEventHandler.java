package kz.muminov.midtermrestaraunt.notification.handler;

import kz.muminov.midtermrestaraunt.notification.event.StaffDeleteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StaffDeleteEventHandler implements ApplicationListener<StaffDeleteEvent> {
    @Override
    public void onApplicationEvent(StaffDeleteEvent staffDeleteEvent) {
        System.out.println("Staff member with id " + staffDeleteEvent.getId() + " was deleted");
    }
}
