package hydrovor;


import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HydrovorTest {

    private int testVolume = 1;
    private int testMaxVolume = 1;

    private Tank tank = new Tank(testMaxVolume,testVolume);


    @Test
    public void hydrovor_volumeEqualsOne_returnOne() throws NullPointerException{
        //Given
        Hydrovor hydrovor = new Hydrovor(tank,testVolume);
        //When
        final int result = hydrovor.getWater();
        //Then
        Assert.assertEquals(1,result);
    }

    @Test
    public void hydrovor_isEmpty_returnZero() throws NullPointerException{

        //Given
        Hydrovor hydrovor = new Hydrovor(tank,0);
        //When
        final int result = hydrovor.getWater();
        //Then
        Assert.assertEquals(0,result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void hydrovor_tankIsNull_returnException(){
        //When
        new Hydrovor(null,1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void hydrovor_volumeIsBelowZero_returnException(){
        //When
        new Hydrovor(tank,-1);
    }
    @Test
    public void hydrovor_hydrovorOnAndTankIsFilled_returnOne(){
        //Given
        Hydrovor hydrovor = new Hydrovor(tank,1);
        //When
        hydrovor.hydrovorOn();
        hydrovor.tick();
        final int result = hydrovor.getWater();
        //Then
        Assert.assertEquals(1,result);
    }
    @Test
    public void hydrovor_hydrovorOffAndTankIsEmpty_returnZero(){
        //Given
        Hydrovor hydrovor = new Hydrovor(new Tank(0,0),0);
        //When
        hydrovor.hydrovorOff();
        hydrovor.tick();
        final int result = hydrovor.getWater();
        //Then
        Assert.assertEquals(0,result);
    }


}
