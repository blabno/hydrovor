package hydrovor;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TankTest {
    @Test(expected = IllegalArgumentException.class)
    public void Tank_maxVolumeLessThan0_exception(){
        new Tank(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Tank_volumeLessThan0_exception(){
        new Tank(1, -1);
    }

    @Test
    public void getWater_notEmpty_return1(){
        //given
        Tank tank = new Tank(1, 1);
        //when
        int result = tank.getWater();
        //then
        assertEquals(1, result);
    }

    @Test
    public void getWater_empty_return0(){
        //given
        Tank tank = new Tank(1, 0);
        //when
        int result = tank.getWater();
        //then
        assertEquals(0, result);
    }

    @Test
    public void addWater_acceptableVolume_accept(){
        //given
        Tank tank = new Tank(1, 0);
        //when
        int accepted = tank.addWater(1);
        //then
        assertEquals(1, accepted);
    }

    @Test
    public void addWater_unacceptableVolume_reject(){
        //given
        Tank tank = new Tank(1, 1);
        //when
        int accepted = tank.addWater(1);
        //then
        assertEquals(0, accepted);
    }

    @Test
    public void addWater_partiallyUnacceptableVolume_rejectSome(){
        //given
        Tank tank = new Tank(10, 6);
        //when
        int accepted = tank.addWater(10);
        //then
        assertEquals(4, accepted);
    }

    @Test
    public void addWater_emptyTank_canGetWaterAfter(){
        //given
        Tank tank = new Tank(1, 0);
        //when
        tank.addWater(1);
        //then
        int result = tank.getWater();
        assertEquals(1, result);
    }
}