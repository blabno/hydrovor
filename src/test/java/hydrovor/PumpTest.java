package hydrovor;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

/**
 * Created by domino on 06.04.15.
 */
public class PumpTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_nullTank_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Pump(null, new Well(1));
    }

    @Test
    public void constructor_nullWell_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Pump(new Tank(1, 1), null);
    }

    @Test
    public void tick_pumpOff_noAction(){
        //given

        Well wellMock = mock(Well.class);
        when(wellMock.getWater(1)).thenReturn(1);
        Tank tankMock = mock(Tank.class);
        when(tankMock.addWater(1)).thenReturn(1);
        Pump pump = new Pump(tankMock, wellMock);


        //when
        pump.off();
        pump.tick();

        //then
        verify(wellMock, never()).getWater(1);
        verify(tankMock, never()).addWater(1);
    }

    @Test
    public void tick_tankNotFull_acceptsWater(){
        //given
        Well wellMock = mock(Well.class);
        when(wellMock.getWater(1)).thenReturn(1);
        Tank tankMock = mock(Tank.class);
        when(tankMock.addWater(1)).thenReturn(1);
        Pump pump = new Pump(tankMock, wellMock);

        //when
        pump.on();
        pump.tick();

        //then
        verify(wellMock).getWater(1);
        verify(tankMock).addWater(1);
        verify(wellMock, never()).addWater(1);
    }

    @Test
    public void tick_tankFull_waterReturn(){
        //given
        Well wellMock = mock(Well.class);
        when(wellMock.getWater(1)).thenReturn(1);
        Tank tankMock = mock(Tank.class);
        when(tankMock.addWater(1)).thenReturn(0);
        Pump pump = new Pump(tankMock, wellMock);

        //when
        pump.on();
        pump.tick();

        //then
        verify(wellMock).getWater(1);
        verify(tankMock).addWater(1);
        verify(wellMock).addWater(1);
    }


}