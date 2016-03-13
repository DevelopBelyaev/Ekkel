package com.company.Chapter10.InnerClasses.Controller;

/**
 * Created by oleg on 13.03.16.
 */
public class GreenHouseController {
    public static void main(String[] args) {
        GreenHouseControls greenHouseControls = new GreenHouseControls();
        greenHouseControls.addEvent(greenHouseControls.new Bell(1000));
        Event[] events = {
                greenHouseControls.new ThermostatNight(0),
                greenHouseControls.new LightOn(200),
                greenHouseControls.new LightOff(400),
                greenHouseControls.new WaterOn(600),
                greenHouseControls.new WaterOff(800),
                greenHouseControls.new ThermostatDay(1400)
        };
        greenHouseControls.addEvent(greenHouseControls.new Restart(2000, events));
        if (args.length == 1) {
            greenHouseControls.addEvent(new GreenHouseControls.Terminate(new Integer(args[0])));
        } else {
            greenHouseControls.addEvent(new GreenHouseControls.Terminate(1000));
        }
        greenHouseControls.run();
    }
}
