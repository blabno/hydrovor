package hydrovor;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class WellTest {


    @Test(expected = IllegalArgumentException.class)
    public void Well_volumeLessThan0_exception(){
        new Well(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWater_volumeLessThan0_exception(){
        //GIVEN
        Well well = new Well(0);
        //WHEN
        well.addWater(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getWater_desiredVolumeLessThan_exception(){
        //GIVEN
        Well well = new Well(0);
        //WHEN
        well.getWater(-1);
    }
    @Test
    public void getWater_empty_noWaterGoingOut(){
        //GIVEN
        Well well = new Well(0);
        //WHEN
        int result = well.getWater(1);
        //THEN
        assertEquals(0, result);
    }
    @Test
    public void getWater_full_waterGoingOut(){
        //GIVEN
        Well well = new Well(10000);
        //WHEN
        int result = well.getWater(1);
        //THEN
        assertEquals(1, result);
    }
    @Test
    public void getWater_someWater_asMuchAsPossibleGoesOut(){
        //GIVEN
        Well well = new Well(5);
        //WHEN
        int result = well.getWater(8);
        //THEN
        assertEquals(5, result);
    }
    @Test
    public void assWater_empty_possibleToGetWater(){
        //GIVEN
        Well well = new Well(0);
        //WHEN
        well.addWater(10);
        int result = well.getWater(1);
        //THEN
        assertEquals(1,result);
    }
}
