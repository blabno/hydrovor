package hydrovor;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class PumpTest {

    Well wellMock = mock(Well.class);
    Tank tankMock = mock(Tank.class);


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
        new Pump(new Tank(10,1), null);
    }


    @Test
    public void tick_pumpOff_noAction(){
        Pump pump = new Pump(tankMock, wellMock);
        when(wellMock.getWater(1)).thenReturn(1);
        pump.off();
        pump.tick();

        verify(wellMock, never()).getWater(1);
    }


    @Test
    public void tick_pumpOntankReturnWater_addWaterToWell(){
        when(wellMock.getWater(1)).thenReturn(1);
        when(tankMock.addWater(1)).thenReturn(0);
        Pump pump = new Pump(tankMock, wellMock);
        pump.on();
        pump.tick();

        verify(wellMock).getWater(1);
        verify(tankMock).addWater(1);
        verify(wellMock).addWater(1);
    }


    @Test
    public void tick_pumpOntankNotReturnWater_nothing(){

        when(wellMock.getWater(1)).thenReturn(1);
        when(tankMock.addWater(1)).thenReturn(1);
        Pump pump = new Pump(tankMock, wellMock);
        pump.on();
        pump.tick();

        verify(wellMock).getWater(1);
        verify(tankMock).addWater(1);
        verify(wellMock, never()).addWater(1);
    }
}
