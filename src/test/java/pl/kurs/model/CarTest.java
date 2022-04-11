package pl.kurs.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void init() {
        car = Mockito.mock(Car.class);
    }

    @Test
    public void shouldReturnFerrariOnGetProducer() {

        // zdefiniwanie zachowania metody zwracajacej
        Mockito.when(car.getProducer()).thenReturn("Ferrari");

        assertEquals("Ferrari", car.getProducer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnGetProducer() {

        Mockito.when(car.getProducer()).thenThrow(new IllegalArgumentException());
        car.getProducer();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnSetProducer() {
        Mockito.doThrow(new IllegalArgumentException()).when(car).setProducer("dupa");

        car.setProducer("dupa");
    }

    @Test
    public void verify(){
        car.setProducer("lamborghini");

        Mockito.verify(car, Mockito.atLeast(1)).setProducer("lamborghini");
   //     Mockito.verify(car, Mockito.never()).setProducer("lamborghini");
        Mockito.verify(car, Mockito.atMost(5)).setProducer("lamborghini");
        Mockito.verify(car, Mockito.times(1)).setProducer("lamborghini");

        Mockito.verify(car, Mockito.times(1)).setProducer(Mockito.anyString());
        Mockito.verify(car, Mockito.times(1)).setProducer(Mockito.contains("bor"));
        Mockito.verify(car, Mockito.times(1)).setProducer(Mockito.matches("\\w+"));
        Mockito.verify(car, Mockito.times(1)).setProducer(Mockito.any());

    }


}