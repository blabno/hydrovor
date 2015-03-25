package hydrovor;

import org.junit.Assert;
import org.junit.Test;

public class HydrovorTest {
    @Test
    public void getWater_volumeOne_returnOne() {
        //Given

        //When
        int result = new Hydrovor(1).getWater();
        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void getWater_volumeZero_returnZero() {
        //Given

        //When
        int result = new Hydrovor().getWater();
        //Then
        Assert.assertEquals(0, result);
    }
}
