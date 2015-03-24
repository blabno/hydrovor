package hydrovor;

import junit.framework.Assert;
import org.junit.Test;

public class WellTest {

    @Test
    public void getWaterIsCorect()
    {

        //give
        Well well =new Well(1);
        //when
        int result =well.getWater(0);
        Assert.assertEquals(1, result);

    }

}
