package hydrovor;

import org.junit.Assert;
import org.junit.Test;

public class TankTest {

    @Test
    public void getWater_zeroVolume_returnZero() {
        //Given
        Tank tank = new Tank(0,0);
        //When
        int result = tank.getWater();
        //Then
        Assert.assertEquals(0,result);
    }

    @Test
    public void getWater_zeroVolume_doesNotChangeVolume() {
        //Given

        //When

        //Then

    }

    @Test
    public void getWater_positiveVolume_returnOne() {
        //Given
        Tank tank = new Tank(0,1);
        //When
        int result = tank.getWater();
        //Then
        Assert.assertEquals(1,result);
    }

    @Test
    public void getWater_positiveVolume_decrementsVolume() {
        //Given

        //When

        //Then

    }

    @Test
    public void addWater_moreAvailableSpaceThanAddedWater_returnsSameVolumeAsParam() {
        //Given

        //When

        //Then

    }

    @Test
    public void addWater_moreAvailableSpaceThanAddedWater_incrementVolumeByValueOfParam() {
        //Given

        //When

        //Then

    }

    @Test
    public void addWater_lessAvailableSpaceThanAddedWater_returnsAcceptedWater() {
        //Given
        final Tank tank = new Tank(2,1);
        //When
        final int result = tank.addWater(2);
        //Then
        Assert.assertEquals(1,result);
    }

    @Test
    public void addWater_lessAvailableSpaceThanAddedWater2_returnsAcceptedWater() {
        //Given
        final Tank tank = new Tank(2,2);
        //When
        final int result = tank.addWater(1);
        //Then
        Assert.assertEquals(0,result);
    }

    @Test
    public void addWater_lessAvailableSpaceThanAddedWater_incrementVolumeToMeetMaxVolume() {
        //Given

        //When

        //Then

    }
    //todo IMPLEMENT constructor test
}
