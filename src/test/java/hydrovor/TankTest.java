package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class TankTest {

    private Tank tank = Mockito.mock(Tank.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void construktor_maxVolumeNoPositive_throwException(){
        exception.expect(IllegalArgumentException.class);
        new Tank(-1, 1);
    }

    @Test
    public void construktor_volumeNoPositive_throwException(){
        exception.expect(IllegalArgumentException.class);
        new Tank(1, -1);
    }


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
        tank.addWater(5);
        int volume = tank.getVolume();

        //then
        Assert.assertEquals(6, volume);
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
