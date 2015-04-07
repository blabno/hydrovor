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
        new Pump(null,new Well(1));
    }

    @Test
    public void constructor_nullWell_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Pump(new Tank(1,1),null);
    }

    @Test
    public void tick_pumpOff_noAction(){
        //given
        Tank tankMock = mock(Tank.class);
        when(tankMock.addWater(1)).thenReturn(1);

        Well wellMock = mock(Well.class);
        when(wellMock.getWater(1)).thenReturn(1);

        Pump pump = new Pump(tankMock, wellMock);

        //when
        pump.off();
        pump.tick();

        //then
        verify(wellMock, never()).getWater(1);
        verify(wellMock, never()).addWater(1);
        verify(tankMock, never()).addWater(1);
    }

    @Test
    public void tick_pumpOnAndTankIsNotFull_addWaterToTank(){
        //given
        Tank tankMock = mock(Tank.class);
        Well wellMock = mock(Well.class);

        when(tankMock.addWater(1)).thenReturn(1);
        when(wellMock.getWater(1)).thenReturn(1);

        Pump pump = new Pump(tankMock, wellMock);

        //when
        pump.on();
        pump.tick();

        //then
        verify(wellMock, times(1)).getWater(1);
        verify(wellMock, never()).addWater(1);
        verify(tankMock, times(1)).addWater(1);
    }

    @Test
    public void tick_pumpOnAndTankIsFull_returnWaterToWell(){
        // Given
        Tank tankMock = mock(Tank.class);
        when(tankMock.addWater(1)).thenReturn(0);

        Well wellMock = mock(Well.class);
        when(wellMock.getWater(1)).thenReturn(1);

        Pump pump = new Pump(tankMock, wellMock);

        // When
        pump.on();
        pump.tick();

        // Then
        verify(wellMock, times(1)).getWater(1);
        verify(tankMock, times(1)).addWater(1);
        verify(wellMock, times(1)).addWater(1);
    }
}