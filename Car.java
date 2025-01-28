import java.awt.*;

public class Car implements Movable {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public int turningAngle;
    public double x;
    public double y;

    public Car(int nrdoors, Color incolor, double enginepower, String modelname){
        nrDoors = nrdoors;
        color = incolor;
        enginePower = enginepower;
        modelName = modelname;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){ currentSpeed= 0.1; }

    public void stopEngine(){ currentSpeed = 0; }

    protected double speedFactor(){ return enginePower * 0.01; }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // Använder currentSpeed från objektet samt turningAngle för att bestämma hastighet och riktning
   public void move() {
        double rad = Math.toRadians(turningAngle);
        x += currentSpeed * Math.cos(rad);
        y += currentSpeed * Math.sin(rad);

   }

      // Ändrar turningAngle negativt för att simulera svängning mot vänster
    public void turnLeft(int angle) {
        if (angle > 180) { angle -= 180; }
        turningAngle -= (angle);
    }

    // Ändrar turningAngle positivt för att simulera svängning mot höger
   public void turnRight(int angle) {
       if (angle > 180) { angle -= 180; }
        turningAngle += (angle);
   }

    public void gas(double amount){
        if(amount < 1 && amount > 0) incrementSpeed(amount);
    }

    public void brake(double amount){
        if(amount < 1 && amount > 0) decrementSpeed(amount);
    }
}
