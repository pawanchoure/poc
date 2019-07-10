/**
 * Created by Pawan on 2/17/2015.
 */
public class Pilot {
    private Plane plane;

    public Pilot(Plane plane) {
        this.plane = plane;
    }

    public boolean readyForFlight() {
        plane.startEngine(Plane.ENGINE_ID_LEFT);
        plane.startEngine(Plane.ENGINE_ID_RIGHT);
        return plane.verifyAllSystems();
    }
}
