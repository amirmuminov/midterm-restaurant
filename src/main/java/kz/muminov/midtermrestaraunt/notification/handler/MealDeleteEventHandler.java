package kz.muminov.midtermrestaraunt.notification.handler;

import kz.muminov.midtermrestaraunt.notification.event.MealDeleteEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MealDeleteEventHandler implements ApplicationListener<MealDeleteEvent> {
    @Override
    public void onApplicationEvent(MealDeleteEvent mealDeleteEvent) {
        System.out.println("Meal with id " + mealDeleteEvent.getId() + " was deleted");
    }
}
