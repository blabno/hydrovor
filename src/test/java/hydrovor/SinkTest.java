package hydrovor;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class SinkTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void Sink_hydrovorIsNull_exception()
    {
        expectedException.expect(IllegalArgumentException.class);
        new Sink(null);
    }

    @Test
    public void getWater_returnValue_hydrovorGetWaterValue()
    {
        Hydrovor hydrovor = Mockito.mock(Hydrovor.class);
        when(hydrovor.getWater()).thenReturn(1);
        Sink sink = new Sink(hydrovor);
        int result = sink.getWater();
        Assert.assertEquals(1,result);
    }

}
