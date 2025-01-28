import java.awt.*;

public class Saab95 extends Car{

    private double turbo;
    
    public Saab95(){
        super(2,Color.red,125,"Saab95");
        stopEngine();
    }

    private void setTurboOn(){
	    turbo = 1.3;
    }

    private void setTurboOff(){
	    turbo = 1;
    }

    public double speedFactor(){
        return super.speedFactor() * turbo;
    }
}
