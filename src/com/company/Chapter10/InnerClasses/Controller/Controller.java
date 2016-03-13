package com.company.Chapter10.InnerClasses.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 13.03.16.
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (eventList.size() >= 0) {
            new ArrayList<>(eventList).stream().filter(event -> event.ready()).forEach(event -> {
                System.out.println(event);
                event.action();
                eventList.remove(event);
            });
        }
    }
}
