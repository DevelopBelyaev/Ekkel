package com.company.Chapter10.InnerClasses.Controller;

/**
 * Created by oleg on 13.03.16.
 */
public class GreenHouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";

    public static class Terminate extends Event {

        Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "shutdown";
        }
    }

    public class LightOn extends Event {

        LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light on";
        }
    }

    public class LightOff extends Event {
        LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light off";
        }
    }

    public class WaterOn extends Event {

        WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "water on";
        }
    }

    public class WaterOff extends Event {
        WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "water off";
        }
    }

    public class ThermostatNight extends Event {

        ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "night";
        }

        @Override
        public String toString() {
            return thermostat;
        }
    }

    public class ThermostatDay extends Event {
        ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "day";
        }

        @Override
        public String toString() {
            return thermostat;
        }
    }

    public class Bell extends Event {
        Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bum";
        }
    }

    public class Restart extends Event {

        private Event[] eventList;

        Restart(long delayTime, Event[] events) {
            super(delayTime);
            eventList = events;
            for (Event e : eventList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event event :
                    eventList) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }
    }


}
