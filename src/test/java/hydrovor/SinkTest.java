package hydrovor;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class SinkTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void constructor_nullHydrovor_throwException() {
        //Given
        expectedException.expect(IllegalArgumentException.class);
        //When
        new Sink(null);
        //Then
    }

    @Test
    public void getWater_allways_delegatesToHydrovor() {
        //Given
        final Hydrovor hydrovor = Mockito.mock(Hydrovor.class);
        final Sink sink = new Sink(hydrovor);
        //final Sink sink = new Sink(new Hydrovor());
        //When
        sink.getWater();
        //Then
        Mockito.verify(hydrovor).getWater();
    }

    @Test
    public void getWater_hydrovorReturnOne_returnOne() {
        //Given
        final Hydrovor hydrovor = Mockito.mock(Hydrovor.class);
        Mockito.when(hydrovor.getWater()).thenReturn(1);
        final Sink sink = new Sink(hydrovor);
        //When
        int result = sink.getWater();
        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void getWater_hydrovorReturnTwo_returnTwo() {
        //Given
        final Hydrovor hydrovor = Mockito.mock(Hydrovor.class);
        Mockito.when(hydrovor.getWater()).thenReturn(2);
        final Sink sink = new Sink(hydrovor);
        //When
        int result = sink.getWater();
        //Then
        Assert.assertEquals(2, result);
    }

}
