package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;

public class TankTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_negativeVolume_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Tank(1, -1);
    }

    @Test
    public void constructor_valueOfVolumeMoreThanMaxValue_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Tank(1, 2);
    }


    @Test
    public void getWater_volumeIsZero_noChange(){
        //given
        Tank tank = new Tank(1, 0);

        //when
        int result = tank.getWater();

        //then
        Assert.assertEquals(0, result);
    }






    @Test
    public void getWater_positiveVolume_decrementsVolume(){
        //given
        Tank tank = new Tank(1, 1);

        //when
        tank.getWater();
        int result = tank.getVolume();

        //then
        Assert.assertEquals(0, result);
    }

    @Test
    public void getWater_negativeVolume_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Tank(1,1).addWater(-1);
    }

    @Test
    public void addWater_availableSpaceIsTooBig_returnsParam(){
        //given
        Tank tank = new Tank(4, 1);

        //when
        int result = tank.addWater(1);

        //then
        Assert.assertEquals(1, result);
    }





    @Test
    public void addWater_enaughtAvailableSpace_returnsAcceptedWater(){
        //given
        Tank tank = new Tank(4,3);

        //when
        int result = tank.addWater(15);

        //then
        Assert.assertEquals(1, result);
    }


    @Test
    public void addWater_notEnaughtSpace_returnsZero(){
        //given
        Tank tank = new Tank(2,2);

        //when
        int result = tank.addWater(2);

        //then
        Assert.assertEquals(0, result);
    }





    @Test
    public void getWater_zeroVolume_returnsZero(){

        //given
        Tank tank = new Tank(1, 0);

        //when
        int result = tank.getWater();

        //then
        Assert.assertEquals(0, result);

    }


    @Test
    public void getWater_positiveVolume_returnsOne(){

        //given
        Tank tank = new Tank(1, 1);

        //when
        int result = tank.getWater();

        //then
        Assert.assertEquals(1, result);

    }


}