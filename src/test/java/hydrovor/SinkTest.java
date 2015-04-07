package hydrovor;

import org.junit.Assert;
import org.junit.Test;

public class SinkTest {

    Hydrovor hydrovor = new Hydrovor(new Tank(1,1),1);

    @Test(expected = NullPointerException.class)
    public void sink_nullHydrovorInConstructor_throwsException(){
        new Sink(null);

    }
    @Test
    public void sink_checkIfThereIsAnyWater_returnValueOne(){
        //Given
        Sink sink = new Sink(hydrovor);
        //When
        int result = sink.getWater();
        //Then
        Assert.assertEquals(1, result);

    }

}
