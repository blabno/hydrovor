package hydrovor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TankTest {

    private Tank tank;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void TankIsEmpty() {
        //        Given
        tank = new Tank(2, 0);
        //        When
        int result = tank.getWater();

        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void IsWater() {
        //        Given
        tank = new Tank(2, 1);
        //        When
        int result = tank.getWater();
        //        Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void IsEmptying() {
        //        Given
        tank = new Tank(2, 1);
        //        When
        tank.getWater();
        int result = tank.getWater();
        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void IsMaxVolumeWorking() {
        //        Given
        tank = new Tank(2, 1);
        //        When
        tank.addWater(2);
        tank.getWater();
        int result = tank.getWater();
        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void EmptyCreation() {
        //        Given
        tank = new Tank(1, 0);
        //        When
        tank.addWater(1);
        int result = tank.getWater();
        //        Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void NotZeroTest() {
        //        Given
        tank = new Tank(1, 0);
        //        When
        tank.addWater(2);
        tank.getWater();
        int result = tank.getWater();
        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void new_tank00() {
        //        Given
        //        When
        //        Then
        exception.expect(IllegalArgumentException.class);
        tank = new Tank(0, 0);
    }
}
