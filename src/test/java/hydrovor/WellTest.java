package hydrovor;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WellTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void Well_VolumeNegative_expectedException()
    {
        expectedException.expect(IllegalArgumentException.class);
        new Well(-1);
    }

    @Test
    public void addWater_volumeNegative_expectedException()
    {
        Well well = new Well(0);
        expectedException.expect(IllegalArgumentException.class);
        well.addWater(-1);
    }

    @Test
    public void getWater_negaticeDesiredVolume_expectedException()
    {
        Well well = new Well(1);
        expectedException.expect(IllegalArgumentException.class);
        well.getWater(-1);
    }

    @Test
    public void getWater_desiredVolumeLessThanVolume_desireVolume()
    {
        Well well = new Well(2);
        int result = well.getWater(1);
        org.junit.Assert.assertEquals(1,result);
    }

    @Test
    public void getWater_desiredVolumeEqualVolume_desiredVolume()
    {
        Well well = new Well(1);
        int result = well.getWater(1);
        org.junit.Assert.assertEquals(1,result);
    }

    @Test
    public void getWater_desiredVolumeGreaterThanVolume_volume()
    {
        Well well = new Well(1);
        int result = well.getWater(2);
        org.junit.Assert.assertEquals(1,result);
    }

    @Test
    public void getWater_getWater_desiredVolumeGeaterThanVolume_volumeEqualzero()
    {
        Well well = new Well(1);
        well.getWater(2);
        int result = well.getWater(2);
        org.junit.Assert.assertEquals(0,result);
    }


}
