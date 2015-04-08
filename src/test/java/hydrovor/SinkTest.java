package hydrovor;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SinkTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void constructor_nullHydrovorGiven_throwException() {
		exception.expect(IllegalArgumentException.class);
		new Sink(null);
	}
	
	@Test
	public void getWater_methodCalled_delegateToHydrovor() {
		// Given
		Hydrovor hydrovor = mock(Hydrovor.class);
		when(hydrovor.getWater()).thenReturn(1);
		Sink sink = new Sink(hydrovor);
		// When
		int result = sink.getWater();
		// Then
		assertEquals(1, result);
	}
	
}
