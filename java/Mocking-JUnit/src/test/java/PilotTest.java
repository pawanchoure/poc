import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Pawan on 2/17/2015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Plane.class)
public class PilotTest{
    @Test
    public void testReadyForFlight() {
        Plane planeMock = PowerMockito.mock(Plane.class);
        Pilot pilot = new Pilot(planeMock);

        Mockito.when(planeMock.verifyAllSystems()).thenReturn(true);

        // testing method
        boolean actualStatus = pilot.readyForFlight();

        Assert.assertEquals(actualStatus, true);
        Mockito.verify(planeMock).startEngine(Plane.ENGINE_ID_LEFT);
        Mockito.verify(planeMock).startEngine(Plane.ENGINE_ID_RIGHT);
    }
}
