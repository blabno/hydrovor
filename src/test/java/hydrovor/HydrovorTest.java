package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class HydrovorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void constructor_nullTank_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Hydrovor(null, 1);
	}
	
	@Test 
	public void constructor_volumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Hydrovor(new Tank(1, 1), -1);
	}
	
	@Test
	public void getWater_isNotEmpty_returns1() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 1);
		// When
		int result = hydrovor.getWater();
		// Then
		assertEquals(1, result);
	}
	
	@Test
	public void getWater_isNotEmpty_decrementsVolume() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 2);
		// When
		hydrovor.getWater();
		int result = hydrovor.getVolume();
		// Then
		assertEquals(1, result);
	}
	
	@Test
	public void getWater_isEmpty_returns0() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
		// When
		int result = hydrovor.getWater();
		// Then
		assertEquals(0, result);
	}
	
	@Test
	public void getWater_isEmpty_doesNotChangeVolume() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
		// When
		hydrovor.getWater();
		int result = hydrovor.getVolume();
		// Then
		assertEquals(0, result);	
	}
	
	@Test
	public void tick_calledWhenOnAndEmpty_returns1() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
		// When
		hydrovor.on();
		hydrovor.tick();
		// Then
		int result = hydrovor.getWater();
		assertEquals(1, result);
	}
	
	@Test
	public void tick_calledWhenOffAndEmpty_returns0() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
		// When
		hydrovor.off();
		hydrovor.tick();
		// Then
		int result = hydrovor.getWater();
		assertEquals(0, result);	
	}
	
	@Test
	public void tick_calledWhenOnAndTankEmpty_returns0() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 0), 0);
		// When
		hydrovor.on();
		hydrovor.tick();
		// Then
		int result = hydrovor.getWater();
		assertEquals(0, result);
	}
	
}
