import java.awt.*;

public class Scania extends Car {

    public int bedAngle = 0;

    public Scania() {
        super(2, Color.blue, 80, "Scania");
        stopEngine();
    }

    public void raiseBed(int amount){
        if (getCurrentSpeed() != 0){
            return;
        }

        bedAngle += amount;
        if (bedAngle > 70){
            bedAngle = 70;
        }
    }

    public void lowerBed(int amount){
        if (getCurrentSpeed() != 0){
            return;
        }

        bedAngle -= amount;
        if (bedAngle < 0){
            bedAngle = 0;
        }
    }

    public void gas(double amount){

    }
}
