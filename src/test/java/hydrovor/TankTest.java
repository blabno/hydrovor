package hydrovor;

import org.junit.Assert;
import org.junit.Test;

public class TankTest {


    @Test
    public void getWater_zeroVolume_doesNotChange() {
        //given
        Tank tank = new Tank(1, 0);

        //when
        tank.getWater();
        int result = tank.getVolume();

        //then
        Assert.assertEquals(0, result);
    }


    @Test
    public void getWater_zeroVolume_returnsZero() {
        //given
        Tank tank = new Tank(1, 0);

        //when
        int result = tank.getWater();

        //then
        Assert.assertEquals(0, result);
    }


    @Test
    public void getWater_positiveVolume_decrementsVolume() {
        //given
        Tank tank = new Tank(1, 1);

        //when
        tank.getWater();
        int result = tank.getVolume();

        //then
        Assert.assertEquals(0, result);
    }


    @Test
    public void getWater_positiveVolume_returnsOne() {
        //given
        Tank tank = new Tank(1, 1);

        //when
        int result = tank.getWater();

        //then
        Assert.assertEquals(1, result);
    }


    @Test
    public void addWater_moreAvailableSpaceThanAddedWater_returnsSameValueAsParam() {
        //given
        Tank tank = new Tank(10, 1);
        int toAdd = 5;

        //when
        int result = tank.addWater(toAdd);

        //then
        Assert.assertEquals(toAdd, result);
    }


    @Test
    public void addWater_moreAvailableSpaceThanAddedWater_incrementVolumeByVolumeOfParam() {
        //given
        Tank tank = new Tank(10, 1);
        int toAdd = 5;

        //when
        int volume = tank.getVolume();
        int result = tank.addWater(toAdd);
        int afterIncrement = volume + result;

        //then
        Assert.assertEquals(volume + toAdd, afterIncrement);
    }


    @Test
    public void addWater_lessAvailableSpaceThanAddedWater_returnsAcceptedWater() {
        //given
        final Tank tank = new Tank(2, 1);

        //when
        final int result = tank.addWater(2);

        //then
        Assert.assertEquals(1, result);
    }


    @Test
    public void addWater_lessAvailableSpaceThanAddedWater2_returnsAcceptedWater() {
        //given
        final Tank tank = new Tank(2, 2);

        //when
        final int result = tank.addWater(2);

        //then
        Assert.assertEquals(0, result);
    }


    @Test
    public void addWater_lessAvailableSpaceThanAddedWater_incrementVolumeToMeetMaxVolume() {
        //given
        final int max = 10;
        final int toAdd = 7;
        Tank tank = new Tank(max, 5);

        //when
        int volume = tank.getVolume();
        int result = tank.addWater(toAdd);

        //then
        Assert.assertEquals(max - volume, result);
    }


}
