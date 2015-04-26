package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class WellTest {
    
    @Rule
	public ExpectedException exception = ExpectedException.none();
    
    @Test
	public void addWater_volumeLessThanZero_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Well(1).addWater(-1);
	}
    
    @Test
    public void getWater_wellEmpty_NotChangeWaterVolume() {
//      Given
        Well well = new Well(0);
//      When
        int result = well.getWater(1);
//      Then
        assertEquals(0, result);
    }
    
    @Test
    public void getWater_receivedNotEnoughVolume_someVolume(){
//      Given
        Well well = new Well(1);
//      When
        int result = well.getWater(2);
//      Then
        assertEquals(1, result);
    }
    
    @Test
    public void getWater_receivedEnoughVolume_neededVolume(){
//      Given
        Well well = new Well(2);
//      When
        int result = well.getWater(2);
//      Then
        assertEquals(2, result);
    }
}
