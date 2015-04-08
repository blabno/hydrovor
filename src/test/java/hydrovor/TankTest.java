package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TankTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void constructor_maxVolumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Tank(-1, 1);
	}
	
	@Test
	public void constructor_maxVolumeEqualZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Tank(0, 1);
	}
	
	@Test
	public void constructor_volumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Tank(1, -1);
	}
	
	@Test
	public void constructor_volumeGreaterThanMaxVolume_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Tank(1, 2);
	}
	
	@Test
	public void getWater_isNotEmpty_returns1() {
		// Given
		Tank tank = new Tank(1, 1);
		// When
		int result = tank.getWater();
		// Then
		assertEquals(1, result);
	}
	
	@Test
	public void getWater_isNotEmpty_decrementsVolume() {
		// Given
		Tank tank = new Tank(1, 1);
		// When
		tank.getWater();
		int result = tank.getVolume();
		// Then
		assertEquals(0, result);
	}
	
	@Test
	public void getWater_isEmpty_returns0() {
		// Given
		Tank tank = new Tank(1, 0);
		// When
		int result = tank.getWater();
		// Then
		assertEquals(0, result);
	}
	
	@Test
	public void getWater_isEmpty_doesNotChangeVolume() {
		// Given
		Tank tank = new Tank(1, 0);
		// When
		tank.getWater();
		int result = tank.getVolume();
		// Then
		assertEquals(0, result);	
	}
	
	@Test 
	public void addWater_volumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Tank(1, 1).addWater(-1);
	}
	
	@Test
	public void addWater_isFullyFilled_rejectWholeVolume() {
		// Given
		Tank tank = new Tank(1, 1);
		// When
		int result = tank.addWater(1);
		// Then
		assertEquals(0, result);		
	}
	
	
	@Test
	public void addWater_canBeFilled_acceptWholeVolume() {
		
		// Given
		Tank tank = new Tank(1, 0);
		// When
		int result = tank.addWater(1);
		// Then
		assertEquals(1, result);		
	}
	
	@Test
	public void addWater_canBePartiallyFilled_acceptSomeVolume() {
		// Given
		Tank tank = new Tank(2, 1);
		// When
		int result = tank.addWater(2);
		// Then
		assertEquals(1, result);		
	}
	
}
