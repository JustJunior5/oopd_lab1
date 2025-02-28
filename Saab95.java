import java.awt.*;

public class Saab95 extends Car{

    public double turbo;
    
    public Saab95(){
        super(2,Color.red,125,"Saab95");
        setTurboOff();
        stopEngine();
    }

    public void setTurboOn(){
	    turbo = 1.3;
    }

    public void setTurboOff(){
	    turbo = 1;
    }

    @Override
    protected double speedFactor() {
        return 0.01 * getEnginePower() * turbo;
    }
}