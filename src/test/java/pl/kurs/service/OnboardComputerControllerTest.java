package pl.kurs.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.kurs.interfaces.RoofController;
import pl.kurs.interfaces.SpeedSensor;

import static org.junit.Assert.*;

public class OnboardComputerControllerTest {

    @Mock
    private SpeedSensor speedSensorMock;

    @Mock
    private RoofController roofControllerMock;

    private OnboardComputerController onboardComputerController;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        onboardComputerController = new OnboardComputerController(speedSensorMock, roofControllerMock);
    }

    @Test
    public void shouldOpenRoofWhenSpeedIs30() {
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(30.0);
        onboardComputerController.openRoof();

        Mockito.verify(roofControllerMock).open();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCloseRoofWhenSpeedIs40() {
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(40.0);
        onboardComputerController.closeRoof();

    }
}