package hydrovor;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TankTest {

    @Test(expected = IllegalArgumentException.class)
    public void Tank_maxVolumeLessThan0_exception(){
        new Tank(-1,1);
    }
    @Test
    public void getWater_notEmpty_return1(){
        //GIVEN
        Tank tank = new Tank(1,1);
        //WHEN
        int result = tank.getWater();
        //THEN
        assertEquals(1,result);
    }

    @Test
    public void getWater_empty_return0(){
        //GIVEN
        Tank tank = new Tank(1,0);
        //WHEN
        int result = tank.getWater();
        //THEN
        assertEquals(0,result);
    }

    @Test
    public void addWater_unacceptableVolume_reject(){
        //GIVEN
        Tank tank =  new Tank(1,1);
        //WHEN
        int accepted = tank.addWater(1);
        //THEN
        assertEquals(0,accepted);
    }

    @Test
    public void addWater_partiallyUnacceptableVolume_rejectSome(){
        //GIVEN
        Tank tank = new Tank(10,6);
        //WHEN
        int accepted = tank.addWater(10);
        //THEN
        assertEquals(4,accepted);
    }

    @Test
    public void addWater_emptyTank_canGetWaterAfter(){
        //GIVEN
        Tank tank = new Tank(1,0);
        //WHEN
        tank.addWater(1);
        //THEN
        int result = tank.getWater();
        assertEquals(1,result);
    }

}
