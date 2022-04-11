package pl.kurs.service;

import pl.kurs.interfaces.RoofController;
import pl.kurs.interfaces.SpeedSensor;

public class OnboardComputerController {

    private SpeedSensor speedSensor;
    private RoofController roofController;

    public OnboardComputerController(SpeedSensor speedSensor, RoofController roofController) {
        this.speedSensor = speedSensor;
        this.roofController = roofController;
    }

    public void openRoof() {
        double speed = speedSensor.getSpeed();

        if (speed <= 30.0) {
            roofController.open();
        } else {
            System.out.println("Nie mozna otworzyc dachu");
        }
    }


    public void closeRoof() {
        double speed = speedSensor.getSpeed();

        if (speed <= 30.0) {
            roofController.close();
        } else {
            throw new IllegalArgumentException("za duza predkosc");
        }
    }
}
