package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
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
    public void addWater_noPositiveVolume_throwException(){
        exception.expect(IllegalArgumentException.class);
        //given
        Well well = new Well(1);

        //when
        well.getWater(-1);
    }


    @Test
    public void addWater_incrementVolume_volumeChange(){
        //given
        Well well = new Well(1);

        //when
        well.addWater(1);
        int after = well.getVolume();

        //given
        Assert.assertEquals(2,after);
    }


    @Test
    public void getWater_parameterNoPositive_throwException(){
        exception.expect(IllegalArgumentException.class);
        //given
        Well well = new Well(0);

        //when
        well.getWater(-1);
    }


    @Test
    public void getWater_parameterLessThanVolume_volumeOut(){
        //given
        Well well = new Well(2);

        //when
        int result = well.getWater(1);

        //given
        Assert.assertEquals(1, result);
    }


    @Test
    public void getWater_parameterLessThanVolume_volumeDeincrement(){
        //given
        Well well = new Well(2);

        //when
        well.getWater(1);
        int after = well.getVolume();

        //given
        Assert.assertEquals(1, after);
    }


    @Test
    public void getWater_parameterMoreThanVolume_someVolumeOut(){
        //given
        Well well = new Well(1);

        //when
        int result = well.getWater(2);

        //given
        Assert.assertEquals(1, result);
    }


}