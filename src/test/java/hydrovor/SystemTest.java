package hydrovor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SystemTest {

    private Well well;

    private Hydrovor hydrovor;

    private Sink sink;

    private Pump pump;

    @Before
    public void setUp() throws Exception
    {
        well = new Well(0);
        Tank tank = new Tank(2, 0);
        pump = new Pump(tank, well);
        hydrovor = new Hydrovor(tank, 0);
        sink = new Sink(hydrovor);
    }

    @Test
    public void simulation_everythingEmpty_noWaterInSink() throws Exception
    {
        //        Given

        //        When
        final int result = sink.getWater();

        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void simulation_wellNotEmpty_waterAvailableInSink() throws Exception
    {
        //        Given
        hydrovor.on();
        pump.on();

        //        When
        well.addWater(1);
        pump.tick();
        hydrovor.tick();
        final int result = sink.getWater();

        //        Then
        Assert.assertEquals(1, result);
    }
}
