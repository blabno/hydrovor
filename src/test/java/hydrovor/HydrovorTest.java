package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;


public class HydrovorTest {
    
    @Test
    public void getWater_nothingIn_return0(){
//      Given
        Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
//      When
        int result = hydrovor.getWater();
//      Then
        assertEquals(0, result);
    }

    @Test
    public void getWater_volumePositiv_return1(){
//      Given
        Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 1);
//      When
        int result = hydrovor.getWater();
//      Then
        assertEquals(1, result);
    }
    
    @Test
    public void tick_invokeWhenOnAndEmpty_return1(){
//      Given
        Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
//      When
        hydrovor.tick();
        hydrovor.on();
        int result = hydrovor.getWater();
//      Then
        assertEquals(1, result);
    }
    
    public void tick_invokeWhenOnAndTankEmpty_return0(){
//      Given
        Hydrovor hydrovor = new Hydrovor(new Tank(1, 0), 0);
//      When
        hydrovor.tick();
        hydrovor.on();
        int result = hydrovor.getWater();
//      Then
        assertEquals(0, result);
    }
    
    public void tick_invokeWhenOffAndEmpty_AndTankNotEmpty_return0(){
//      Given
        Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
//      When
        hydrovor.tick();
        hydrovor.off();
        int result = hydrovor.getWater();
//      Then
        assertEquals(0, result);
    }
}
