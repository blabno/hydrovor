package hydrovor;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HydrovorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_TankIsNull_throwException() {
        exception.expect(IllegalArgumentException.class);
        new Hydrovor(null, 1);
    }

    @Test
    public void constructor_volumeIsLessThanZero_throwException(){
        exception.expect(IllegalArgumentException.class);
        new Hydrovor(new Tank(1, 1), -5);
    }

    @Test
    public void getWater_volumeIsPositive_returnsOne(){
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 1);

        //when
        int result = hydrovor.getWater();

        //then
        Assert.assertEquals(1, result);
    }
    @Test
    public void tick_hydrovorOn_incrementVolume() {
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);

        //when
        hydrovor.on();
        hydrovor.tick();
        int result = hydrovor.getVolume();

        //then
        Assert.assertEquals(1, result);
    }
    @Test
    public void getWater_volumeIsZero_returnsZero(){

        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);

        //when
        int result = hydrovor.getWater();

        //then
        Assert.assertEquals(0, result);

    }

    @Test
    public void getWater_volumeIsPositive_decrementsVolume(){
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 1);

        //when
        hydrovor.getWater();
        int result = hydrovor.getVolume();

        //then
        Assert.assertEquals(0, result);
    }

    @Test
    public void tick_hydrovorOff_volumeIsNoChange() {
        //given
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);

        //when
        hydrovor.tick();
        int result = hydrovor.getVolume();

        //then
        Assert.assertEquals(0, result);
    }





}
