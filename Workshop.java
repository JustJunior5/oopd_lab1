import java.util.ArrayList;
import java.util.List;

public class Workshop<C extends Car> {
    public List<C> stored;
    private int capacity;


    public Workshop(int cap){
        stored = new ArrayList<>();
        capacity = cap;
    }
    // Attempts to store car if not already present in storage and storage is not full
    public void storeCar(C car){
        if (stored.contains(car)) {
            System.out.println(car.getClass().getSimpleName() + " is already in workshop.");
            return;
        }
        if (stored.size() < capacity) {
            stored.add(car);
            System.out.println(car.getClass().getSimpleName() + " stored.");
        } else {
            System.out.println("Workshop full.");
        }
    }
    // Osäker på vad exakt dom menar med den här delen
    public void removeCar(C car){
    if (stored.contains(car)) {
        stored.remove(car);
        System.out.println(car.getClass().getSimpleName() + " removed from workshop.");
    } else {
        System.out.println(car.getClass().getSimpleName() + " is not in workshop");
        }
    }
    /*
     @Test
    void testWorkshop(){
        Volvo240 volvo240 = new Volvo240();
        Workshop<Volvo240> volvo240Workshop = new Workshop<>(5);
        volvo240Workshop.storeCar(volvo240);
        assertTrue(volvo240Workshop.stored.contains(volvo240));
        volvo240Workshop.removeCar(volvo240);
        assertFalse(volvo240Workshop.stored.contains(volvo240));
    }
     */
}
