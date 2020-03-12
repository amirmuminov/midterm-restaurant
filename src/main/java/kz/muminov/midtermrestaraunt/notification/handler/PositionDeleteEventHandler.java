package kz.muminov.midtermrestaraunt.notification.handler;

import kz.muminov.midtermrestaraunt.notification.event.PositionDeleteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PositionDeleteEventHandler implements ApplicationListener<PositionDeleteEvent> {

    @Override
    public void onApplicationEvent(PositionDeleteEvent positionDeleteEvent) {
        System.out.println("Position with id  " + positionDeleteEvent.getId() + " is deleted");
    }

}
