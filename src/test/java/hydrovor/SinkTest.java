package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SinkTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_negativeVolume_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Sink(null);
    }

    @Test
    public void getWater_calledMethod_delegateToHydrovor() {
        // Given
        Hydrovor hydrovorMock = mock(Hydrovor.class);
        when(hydrovorMock.getWater()).thenReturn(1);
        Sink sink = new Sink(hydrovorMock);

        // When
        int result = sink.getWater();

        // Then
        Assert.assertEquals(1, result);
    }


}