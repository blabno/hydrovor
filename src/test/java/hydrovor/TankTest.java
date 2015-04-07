package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TankTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void tank_maxValueLessThanZero_exception()
    {
        expectedException.expect(IllegalArgumentException.class);
        new Tank(-1,1);
    }

    @Test
    public void tank_valueLessThanZero_exception()
    {
        expectedException.expect(IllegalArgumentException.class);
        new Tank(1,-1);
    }

    @Test
    public void getWater_nonepositiveValue_returnZero()
    {
        Tank tank = new Tank(1,0);
        int result = tank.getWater();
        Assert.assertEquals(0,result);
    }

    @Test
    public void getWater_positiveValue_returnOne()
    {
        Tank tank = new Tank(1,1);
        int result = tank.getWater();
        Assert.assertEquals(1,result);
    }

    @Test
    public void addWater_addLessThanZero_exception()
    {
        expectedException.expect(IllegalArgumentException.class);
        Tank tank = new Tank(1,1);
        int result = tank.addWater(1);
    }

    @Test
    public void addWater_complementTank_valuecomplement()
    {
        Tank tank = new Tank(2,1);
        int result = tank.addWater(2);
        Assert.assertEquals(1,result);
    }

    @Test
    public void addWater_TankCanGetAddWater_addValue()
    {
        Tank tank = new Tank(3,1);
        int result = tank.addWater(1);
        Assert.assertEquals(1,result);
    }

}
