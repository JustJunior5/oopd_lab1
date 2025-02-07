import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Saab95 saab;
    private Volvo240 volvo;

    @BeforeEach
    void createCar() {
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    void testSpeedSaab() {
        assertEquals(0, saab.currentSpeed);

        saab.startEngine();
        assertEquals(0.1, saab.currentSpeed);

        saab.setTurboOn();
        assertEquals(1.3, saab.turbo);

        saab.gas(1); //Borde bli 1.725
        assertEquals(1.725, saab.currentSpeed);

        saab.move();
        assertNotEquals(0, saab.y);
        assertEquals(0, saab.x);

        saab.setTurboOff();
        assertEquals(1, saab.turbo);

        saab.stopEngine();
        assertEquals(0, saab.currentSpeed);
    }

    @Test
    void testSpeedVolvo() {
        assertEquals(0, volvo.currentSpeed);

        volvo.startEngine();
        assertEquals(0.1, volvo.currentSpeed);

        volvo.gas(1); //Borde bli 1.35
        assertEquals(1.35, volvo.currentSpeed);

        volvo.move();
        assertNotEquals(0, volvo.y);
        assertEquals(0, volvo.x);

        volvo.stopEngine();
        assertEquals(0, volvo.currentSpeed);
    }

   @Test
    void testTurnLeft() {
        saab.startEngine();
        saab.gas(1);
        saab.turnLeft(45);
        saab.move();

        assertEquals(saab.x * -1, saab.y);
    }

    @Test
    void testTurnRight() {
        volvo.startEngine();
        volvo.gas(1);
        volvo.turnRight(45);
        volvo.move();

        assertEquals(volvo.x, volvo.y);
    }

    @Test
    void testGas(){
        saab.startEngine();
        saab.gas(1.0);

        assertTrue(saab.currentSpeed > 0.1);
    }

    @Test
    void testBrake(){
        volvo.startEngine();
        volvo.brake(1.0);

        assertTrue(volvo.currentSpeed < 0.1);
    }
}


