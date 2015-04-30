package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

public class PumpTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void constructor_nullTankGiven_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Pump(null, new Well(1));
	}
	
	@Test
	public void constructor_nullWellGiven_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Pump(new Tank(1, 1), null);
	}
	
	@Test
	public void tick_pumpIsOff_noActionTaken() {
		// Given
		Tank tank = mock(Tank.class);
		when(tank.addWater(1)).thenReturn(1);
		Well well = mock(Well.class);
		when(well.getWater(1)).thenReturn(1);
		Pump pump = new Pump(tank, well);
		// When
		pump.off();
		pump.tick();
		// Then
		verify(well, never()).getWater(1);
		verify(tank, never()).addWater(1);
	}
	
	@Test
	public void tick_pumpIsOnAndTankIsNotFullyFilled_fillTank() {
		// Given
		Tank tank = mock(Tank.class);
		when(tank.addWater(1)).thenReturn(1);
		Well well = mock(Well.class);
		when(well.getWater(1)).thenReturn(1);
		Pump pump = new Pump(tank, well);
		// When
	    pump.on();
		pump.tick();
		// Then
		verify(well, times(1)).getWater(1);
		verify(tank, times(1)).addWater(1);
		verify(well, never()).addWater(1);
	}
	
	@Test
	public void tick_pumpIsOnAndTankIsFullyFilled_returnsWaterToWell() {
		// Given
		Tank tank = mock(Tank.class);
		when(tank.addWater(1)).thenReturn(0);
		Well well = mock(Well.class);
		when(well.getWater(1)).thenReturn(1);
		Pump pump = new Pump(tank, well);
		// When
		pump.on();
		pump.tick();
		// Then
		verify(well, times(1)).getWater(1);
		verify(tank, times(1)).addWater(1);
		verify(well, times(1)).addWater(1);
	}
	
}
