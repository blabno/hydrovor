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
        //given
        Well well = new Well(0);
        //when
        well.addWater(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWater_desiredVolumeLessThan_exception(){
        //given
        Well well = new Well(0);
        //when
        well.getWater(-1);
    }

    @Test
    public void getWater_empty_noWaterGoingOut(){
        //given
        Well well = new Well(0);
        //when
        int result = well.getWater(1);
        //then
        assertEquals(0, result);
    }

    @Test
    public void getWater_full_waterGoingOut(){
        //given
        Well well = new Well(10000);
        //when
        int result = well.getWater(1);
        //then
        assertEquals(1, result);
    }

    @Test
    public void getWater_someWater_asMuchAsPossibleGoesOut(){
        //given
        Well well = new Well(5);
        //when
        int result = well.getWater(8);
        //then
        assertEquals(5, result);
    }

    @Test
    public void addWater_empty_possibleToGetWater(){
        //given
        Well well = new Well(0);
        //when
        well.addWater(10);
        int result = well.getWater(1);
        //then
        assertEquals(1, result);
    }
}
