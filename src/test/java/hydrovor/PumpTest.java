package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PumpTest {
    
    @Test
    public void tick_pumpOff_noAction(){
//      Given
        Tank tankMock = mock(Tank.class);
        when(tankMock.addWater(1)).thenReturn(1);
        Well wellMock = mock(Well.class);
        when(wellMock.getWater(1)).thenReturn(1);
        Pump pump = new Pump(tankMock, wellMock);
//      When
        pump.off();
        pump.tick();
//      Then
        verify(wellMock, never()).getWater(1);
        verify(wellMock, never()).addWater(1);
        verify(tankMock, never()).addWater(1);
    }

    @Test
    public void tick_pumpIsOnAndTankIsNotFullyFilled_fillTank(){
//      Given
        Tank tankMock = mock(Tank.class);
        Well wellMock = mock(Well.class);
        when(tankMock.addWater(1)).thenReturn(1);
        when(wellMock.getWater(1)).thenReturn(1);
        Pump pump = new Pump(tankMock, wellMock);
//      When
        pump.on();
        pump.tick();
//      Then
        verify(wellMock, times(1)).getWater(1);
        verify(wellMock, never()).addWater(1);
        verify(tankMock, times(1)).addWater(1);
    }

    @Test
    public void tick_pumpIsOnAndTankIsFull_returnWaterToWell(){
//      Given
        Tank tankMock = mock(Tank.class);
        when(tankMock.addWater(1)).thenReturn(0);
        Well wellMock = mock(Well.class);
        when(wellMock.getWater(1)).thenReturn(1);
        Pump pump = new Pump(tankMock, wellMock);
//      When
        pump.on();
        pump.tick();
//      Then
        verify(wellMock, times(1)).getWater(1);
        verify(tankMock, times(1)).addWater(1);
        verify(wellMock, times(1)).addWater(1);
    } 
}