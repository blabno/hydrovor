package hydrovor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class HydrovorTest {

    private Tank tank;
    private Hydrovor hydrovor;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void TankIsNull() {
        //        Given
        //        When
        //        Then
        exception.expect(IllegalArgumentException.class);
        hydrovor = new Hydrovor(null, 0);
    }

    @Test
    public void HydrovorIsReturningWater() {
        //        Given
        tank = new Tank(10, 10);
        hydrovor = new Hydrovor(tank, 1);
        //        When
        int result = hydrovor.getWater();
        //        Then 
        Assert.assertEquals(1, result);
    }

    @Test
    public void HydrovorIsEmptying() {
        //        Given
        tank = new Tank(10, 2);
        hydrovor = new Hydrovor(tank, 1);
        //        When
        hydrovor.getWater();
        int result = hydrovor.getWater();
        //        Then 
        Assert.assertEquals(0, result);
    }

    @Test
    public void HydrovorIsFilling() {
        //        Given
        tank = new Tank(10, 2);
        hydrovor = new Hydrovor(tank, 0);
        //        When
        hydrovor.on();
        hydrovor.tick();
        int result = hydrovor.getWater();
        //        Then 
        Assert.assertEquals(1, result);
    }

    public void HydrovorIsNotFillingIfOff() {
        //        Given
        tank = new Tank(10, 2);
        hydrovor = new Hydrovor(tank, 0);
        //        When
        hydrovor.on();
        hydrovor.tick();
        int resulttemp = hydrovor.getWater();
        hydrovor.off();
        int result = hydrovor.getWater();
        //        Then 
        Assert.assertEquals(1, resulttemp);
        Assert.assertEquals(0, result);
    }

    @Test
    public void HydrovorIsDefaultOff() {
        //        Given
        tank = new Tank(10, 2);
        hydrovor = new Hydrovor(tank, 0);
        //        When
        hydrovor.tick();
        int result = hydrovor.getWater();
        //        Then 
        Assert.assertEquals(0, result);
    }

    @Test
    public void HydrovorIsNotMinusFilled() {
        //        Given
        tank = new Tank(10, 2);
        //        When
        //        Then 
        exception.expect(IllegalArgumentException.class);
        hydrovor = new Hydrovor(tank, -10);
    }
}
