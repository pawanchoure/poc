/**
 * Created by Pawan on 2/17/2015.
 */
public final class Plane {
    public static final int ENGINE_ID_RIGHT = 2;
    public static final int ENGINE_ID_LEFT = 1;

    public boolean verifyAllSystems() {
        throw new UnsupportedOperationException("Fail if not mocked!");
    }

    public void startEngine(int engineId) {
        throw new UnsupportedOperationException(
                "Fail if not mocked! [engineId=" + engineId + "]");
    }
}
