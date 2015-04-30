package hydrovor;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HydrovorTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_nullTank_throwException(){
        new Hydrovor(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_volumeLessThan0_throwException(){
        new Hydrovor(new Tank(1,1), -1);
    }

    @Test
    public void getWater_notEmpty_returns1(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 1);
        //WHEN
        int result = hydrovor.getWater();
        //THEN
        assertEquals(1, result);
    }

    @Test
    public void getWater_empty_returns0(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);
        //WHEN
        int result = hydrovor.getWater();
        //THEN
        assertEquals(0, result);
    }

    @Test
    public void tick_callWhenOnAndTankEmpty_return0(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,0), 0);
        //WHEN
        hydrovor.on();
        hydrovor.tick();
        //THEN
        int result = hydrovor.getWater();
        assertEquals(0, result);
    }
    @Test
    public void tick_callWhenOnAndTankEmpty_return1(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);
        //WHEN
        hydrovor.on();
        hydrovor.tick();
        //THEN
        int result = hydrovor.getWater();
        assertEquals(1, result);
        @Test
        public void tick_callWhenOffAndEmpty_return0(){
            //GIVEN
            Hydrovor hydrovor = new Hydrovor(new Tank(1,1),0);
            //WHEN
            hydrovor.off();
            hydrovor.tick();
            //THEN
            int result = hydrovor.getWater();
            assertEquals(0, result);
        }
    }
