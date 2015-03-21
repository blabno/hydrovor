package hydrovor;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HydrovorTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_nullTank_throwException() {
        new Hydrovor(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_volumeLessThan0_throwException(){
        new Hydrovor(new Tank(1, 1), -1);
    }

    @Test
    public void getWater_notEmpty_returns1(){
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 1);
        //when
        int result = hydrovor.getWater();
        //then
        assertEquals(1, result);
    }

    @Test
    public void getWater_empty_returns0(){
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1, 1), 0);
        //when
        int result = hydrovor.getWater();
        //then
        assertEquals(0, result);
    }
}
