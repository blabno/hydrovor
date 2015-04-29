package hydrovor;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class SinkTest {

    @Test
    public void getWater_call_delegateToHydrovor(){
        //given
        Hydrovor hydrovorMock = mock(Hydrovor.class);
        when(hydrovorMock.getWater()).thenReturn(1);
        Sink sink = new Sink(hydrovorMock);

        //when
        int result = sink.getWater();

        //then
        assertEquals(1, result);
    }

    @Test
    public void getWater_call_delegateToHydrovor2(){
        //given
        Hydrovor hydrovorMock = mock(Hydrovor.class);
        when(hydrovorMock.getWater()).thenReturn(0);
        Sink sink = new Sink(hydrovorMock);

        //when
        int result = sink.getWater();

        //then
        assertEquals(0, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_nullGiven_throwException(){
        new Sink(null);
    }
}