package hydrovor;


import org.junit.Assert;
import org.junit.Test;

public class HydrovorTest {


    private Hydrovor hydrovor = new Hydrovor(0);

    @Test
    public void hydrovor_isEmpty_returnZero() throws NullPointerException{
        //Given

        //When
        final int result = hydrovor.getWater(0);
        //Then
        Assert.assertEquals(0,result);
    }


}
