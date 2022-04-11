package zadanie.service;

import zadanie.interfaces.DistanceSensor;
import zadanie.interfaces.LightController;
import zadanie.interfaces.SpeedSensor;

public class RoadLightController {

    private DistanceSensor distanceSensor;
    private SpeedSensor speedSensor;
    private LightController lightController;

    public RoadLightController(DistanceSensor distanceSensor, SpeedSensor speedSensor, LightController lightController) {
        this.distanceSensor = distanceSensor;
        this.speedSensor = speedSensor;
        this.lightController = lightController;
    }

    public void changeLightToRed(){
        double speed = speedSensor.getSpeed();
        double distance = distanceSensor.getDistance();

        if(speed > 40 && distance <= 50){
            lightController.changeLightToRed();
        }
    }
}
