package hydrovor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class WellTest {

    private Well well;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void WellIsEmpty() {
        //        Given
        well = new Well(0);
        //        When
        int result = well.getWater(1);

        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void IsWater() {
        //        Given
        well = new Well(10);
        //        When
        int result = well.getWater(10);
        //        Then
        Assert.assertEquals(10, result);
    }

    @Test
    public void IsEmptying() {
        //        Given
        well = new Well(10);
        //        When
        well.getWater(10);
        int result = well.getWater(10);
        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void volume_negative() {
        exception.expect(IllegalArgumentException.class);
        new Well(-10);
    }

    @Test
    public void addwater_negative() {
        //        Given
        well = new Well(10);
        //        When
        //        Then
        exception.expect(IllegalArgumentException.class);
        well.getWater(-10);
    }

    @Test
    public void getwater_negative() {
        //        Given
        well = new Well(10);
        //        When
        //        Then
        exception.expect(IllegalArgumentException.class);
        well.getWater(-10);
    }
}
