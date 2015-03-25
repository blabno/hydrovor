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
	public void getWater_notEmpty_returns1() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 1);
		// When
		int result = hydrovor.getWater();
		// Then
		assertEquals(1, result);
	}
	
	@Test
	public void getWater_notEmpty_decrementsVolume() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 2);
		// When
		hydrovor.getWater();
		// Then
		assertEquals(1, hydrovor.getVolume());
	}
	
	@Test
	public void getWater_empty_returns0() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
		// When
		int result = hydrovor.getWater();
		// Then
		assertEquals(0, result);
	}
	
	@Test
	public void getWater_empty_doesNotChangeVolume() {
		// Given
		Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
		// When
		hydrovor.getWater();
		// Then
		assertEquals(0, hydrovor.getVolume());	
	}
	
	// TODO tests for tick()
	
}
