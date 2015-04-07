package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SinkTest {

    @Test
    public void getWater_methodInvoked_delegateToHydrovor() {
//      Given
        Hydrovor hydrovorMock = mock(Hydrovor.class);
        when(hydrovorMock.getWater()).thenReturn(1);
        Sink sink = new Sink(hydrovorMock);
//      When
        int result = sink.getWater();
//      Then
        assertEquals(1, result);
    }
}
