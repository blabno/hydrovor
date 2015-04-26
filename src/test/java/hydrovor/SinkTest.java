package hydrovor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class SinkTest {

    private Tank tank;
    private Hydrovor hydrovor;
    private Sink sink;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void HydrovorIsNull() {
        //        Given
        //        When
        //        Then
        exception.expect(IllegalArgumentException.class);
        sink = new Sink(null);
    }

    @Test
    public void HydrovorHasWater() {
        //        Given
        tank = new Tank(10, 10);
        hydrovor = new Hydrovor(tank, 1);
        sink = new Sink(hydrovor);
        //        When
        int result = sink.getWater();
        //        Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void HydrovorIsEmpty() {
        //        Given
        tank = new Tank(10, 10);
        hydrovor = new Hydrovor(tank, 0);
        sink = new Sink(hydrovor);
        //        When
        int result = sink.getWater();
        //        Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void HydrovorIsFulling() {
        //        Given
        tank = new Tank(10, 10);
        hydrovor = new Hydrovor(tank, 0);
        sink = new Sink(hydrovor);
        //        When
        int result0 = sink.getWater();
        hydrovor.on();
        hydrovor.tick();
        int result = sink.getWater();
        int result2 = sink.getWater();
        //        Then
        Assert.assertEquals(0, result0);
        Assert.assertEquals(1, result);
        Assert.assertEquals(0, result2);
    }
}
