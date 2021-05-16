package cz.muni.fi.pv260.productfilter;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Michal Zelenák, Jozef Vanický
 * @created 14.05.2021
 * @project pv260-assignment02-task03
 **/

public class AtLeastNOfFilterTest {

    @Mock
    Filter filter1 = mock(Filter.class),
           filter2 = mock(Filter.class),
           filter3 = mock(Filter.class),
           filter4 = mock(Filter.class);

    /**
     * Test that the constructor throws FilterNeverSucceeds exception as documented (if n is higher than number of child filters).
     */
    @Test
    public void filterNeverSucceedsConstructorTest() {
        assertThrows(FilterNeverSucceeds.class, () -> new AtLeastNOfFilter<Integer>(2, filter1));
    }

    /**
     * Test that the constructor throws IllegalArgumentException exception as documented (if n is 0 or lower).
     */
    @Test
    public void illegalArgumentExceptionConstructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new AtLeastNOfFilter<Integer>(0, filter1));
        assertThrows(IllegalArgumentException.class, () -> new AtLeastNOfFilter<Integer>(-1, filter1));
        assertThrows(IllegalArgumentException.class, () -> new AtLeastNOfFilter<Integer>(-10, filter1));
    }

    /**
     * Test that the filter passes if at least exactly n child filters pass.
     */
    @Test
    public void passIfExactlyOnePasses(){
        when(filter1.passes(Color.BLACK)).thenReturn(false);
        when(filter2.passes(Color.BLACK)).thenReturn(false);
        when(filter3.passes(Color.BLACK)).thenReturn(true);
        when(filter4.passes(Color.BLACK)).thenReturn(false);

        AtLeastNOfFilter atLeastNOfFilter = new AtLeastNOfFilter(1, filter1, filter2, filter3, filter4);
        assertTrue(atLeastNOfFilter.passes(Color.BLACK));
    }

    /**
     * Test that the filter fails if at most n-1 child filters pass.
     */
    @Test
    public void FailsIfnMinusOnePasses(){
        when(filter1.passes(Color.BLACK)).thenReturn(true);
        when(filter2.passes(Color.BLACK)).thenReturn(true);
        when(filter3.passes(Color.BLACK)).thenReturn(true);
        when(filter4.passes(Color.BLACK)).thenReturn(false);

        AtLeastNOfFilter atLeastNOfFilter = new AtLeastNOfFilter(4, filter1, filter2, filter3, filter4);
        assertFalse(atLeastNOfFilter.passes(Color.BLACK));
    }
}