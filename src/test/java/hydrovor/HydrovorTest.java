package hydrovor;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class HydrovorTest {

    private Tank tank= Mockito.mock(Tank.class);
    @Rule
    public ExpectedException expectedException= ExpectedException.none();

    @Test
    public void hydrovor_tankIsNull_exception() {
            expectedException.expect(IllegalArgumentException.class);
            new Hydrovor(null,1);
        }
    @Test
    public void hydrovor_volumeLessThanZero_exception(){
        expectedException.expect(IllegalArgumentException.class);
        new Hydrovor(tank,-1);
    }
    @Test
    public void getWater_volumeEqualZero_valueZero()
    {
        Hydrovor hydro=new Hydrovor(tank,0);

        int result=hydro.getWater();
        org.junit.Assert.assertEquals(0,result);

    }

    @Test
    public void getWater_volumePositive_valueOne()
    {
        Hydrovor hydro=new Hydrovor(tank,1);

        int result=hydro.getWater();
        org.junit.Assert.assertEquals(1,result);

    }
    @Test
    public void tick_turnOnIsFalse_volumeUnchanged()
    {

        when(tank.addWater(1)).thenReturn(1);
        Hydrovor hydro=new Hydrovor(tank,0);
        hydro.off();
        int before=hydro.getWater();
        hydro.tick();
        int after=hydro.getWater();
        org.junit.Assert.assertEquals(before,after);


    }
    @Test
    public void tick_turnOnIsTrue_volumeChanged()
    {

        when(tank.getWater()).thenReturn(1);
        Hydrovor hydro=new Hydrovor(tank,0);
        hydro.on();
        int before=hydro.getWater();
        hydro.tick();
        int after=hydro.getWater();
        org.junit.Assert.assertNotEquals(before,after);


    }



}
