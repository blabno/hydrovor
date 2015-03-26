package hydrovor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class WellTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void constructor_volumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Well(-1);
	}
	
	@Test
	public void addWater_volumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Well(1).addWater(-1);
	}
	
	@Test 
	public void getWater_desiredVolumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Well(1).getWater(-1);
	}
	
	@Test
	public void getWater_wellIsEmpty_noVolumeGoingOut() {
		// Given
		Well well = new Well(0);
		// When
		int result = well.getWater(1);
		// Then
		assertEquals(0, result);		
	}
	
	@Test
	public void getWater_enoughVolumeInWell_desiredVolumeGoingOut() {
		// Given
		Well well = new Well(2);
		// When
		int result = well.getWater(1);
		// Then
		assertEquals(1, result);				
	}
	
	@Test
	public void getWater_notEnoughVolumeInWell_someVolumeGoingOut() {
		// Given
		Well well = new Well(1);
		// When
		int result = well.getWater(2);
		// Then
		assertEquals(1, result);		
	}
	
}
