package hydrovor;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class SinkTest {

    @Test
    public void getWater_call_delegateToHydrovor(){
        //GIVEN
        Hydrovor hydrovorMock = mock(Hydrovor.class);
        when(hydrovorMock.getWater()).thenReturn(1);
        Sink sink = new Sink(hydrovorMock);
        //WHEN
        int result = sink.getWater();
        //THEN
        assertEquals(1, result);
    }
    @Test
    public void getWater_call_delegateToHydrovor2(){
        //GIVEN
        Hydrovor hydrovorMock = mock(Hydrovor.class);
        when(hydrovorMock.getWater()).thenReturn(0);
        Sink sink = new Sink(hydrovorMock);
        //WHEN
        int result = sink.getWater();
        //THEN
        assertEquals(0, result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void constructor_nullGiven_throwException(){
        new Sink (null);
    }

}
