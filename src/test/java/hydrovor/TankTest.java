package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TankTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
	
    @Test
    public void constructor_maxVolumeLessThanZero_throwException(){
        exception.expect(IllegalArgumentException.class);
	new Tank(-1, 1);
    }
    
    @Test
    public void getWater_isEmpty_returns0(){
//      Given
        Tank tank = new Tank(1, 0);
//      When
        int result = tank.getWater();
//      Then
        assertEquals(0, result);
    }
    
    @Test
    public void getWater_isNotEmpty_return1(){
//      Given
        Tank tank = new Tank(1, 1);
//      When
        int result = tank.getWater();
//      Then
        assertEquals(1, result);
    }
    
    @Test
    public void getWater_isEmpty_NotChangeWaterVolume() {
//      Given
        Tank tank = new Tank(1, 0);
//      When
        tank.getWater();
        int result = tank.getVolume();
//      Then
        assertEquals(0, result);
    }
    
    @Test
    public void getWater_isNotEmpty_ChangeWaterVolume() {
//      Given
        Tank tank = new Tank(1, 1);
//      When
        tank.getWater();
        int result = tank.getVolume();
//      Then
        assertEquals(0, result);
    }
}
