package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SinkTest {

    Hydrovor hydrovorMock = mock(Hydrovor.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_nullHydrovor_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Sink(null);
    }

    @Test
    public void getWater_methodCalled_delegateToHydrovor() {
        when(hydrovorMock.getWater()).thenReturn(1);
        Sink sink = new Sink(hydrovorMock);

        int result = sink.getWater();

        Assert.assertEquals(1, result);
    }
}
