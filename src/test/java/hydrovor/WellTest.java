package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WellTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_negativeVolume_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Well(-1);
    }






    @Test
    public void getWater_negativeDesiredVolume_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Well(1).getWater(-1);
    }

    @Test
    public void getWater_notEnoughVolume_someVolume(){
        // Given
        Well well = new Well(1);

        // When
        int result = well.getWater(2);

        // Then
        Assert.assertEquals(1, result);
    }


    @Test
    public void addWater_negativeVolume_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Well(1).addWater(-1);
    }
    @Test
    public void getWater_EnoughVolume_desiredVolume(){
        // Given
        Well well = new Well(1);

        // When
        int result = well.getWater(1);

        // Then
        Assert.assertEquals(1, result);
    }



}