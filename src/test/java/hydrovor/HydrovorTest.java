package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class HydrovorTest {

    private Tank tank = Mockito.mock(Tank.class);
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_nullTank_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Hydrovor(null, 1);
    }

    @Test
    public void constructor_volumeLessThanZero_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Hydrovor(new Tank(1, 1), -1);
    }


    @Test
    public void getWater_positiveVolume_returnsOne(){
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 1);

        //when
        int result = hydrovor.getWater();

        //then
        Assert.assertEquals(1,result);
    }

    @Test
    public void getWater_zeroVolume_returnsZero(){
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);

        //when
        int result = hydrovor.getWater();

        //then
        Assert.assertEquals(0,result);
    }

    @Test
    public void tick_hydrovorOn_volumeChange(){

        when(tank.getWater()).thenReturn(1);
        Hydrovor hydrovor = new Hydrovor(tank, 0);
        hydrovor.on();

        int before = hydrovor.getWater();
        hydrovor.tick();
        int after = hydrovor.getWater();

        Assert.assertNotEquals(before, after);
    }

    @Test
    public void tick_hydrovorOff_volumeNotChange(){

        Hydrovor hydrovor = new Hydrovor(tank, 0);
        hydrovor.off();

        int before = hydrovor.getWater();
        hydrovor.tick();
        int after = hydrovor.getWater();

        Assert.assertEquals(before, after);
    }

}
