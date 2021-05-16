package cz.muni.fi.pv260.productfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Michal Zelenák, Jozef Vanický
 * @created 14.05.2021
 * @project pv260-assignment02-task03
 **/
public class AtLeastNOfFilterTest {

    @Mock
    Filter<Integer> filter1, filter2, filter3, filter4;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test that the constructor throws FilterNeverSucceeds exception as documented (if n is higher than number of child filters).
     */
    @Test
    public void filterNeverSucceedsConstructorTest() {
        List<Filter<Integer>> filters = new ArrayList<>(Collections.singletonList(filter1));
        assertThrows(FilterNeverSucceeds.class, () -> new AtLeastNOfFilter<>(2, filters.get(0)));
    }

    /**
     * Test that the constructor throws IllegalArgumentException exception as documented (if n is 0 or lower).
     */
    @Test
    public void illegalArgumentExceptionConstructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new AtLeastNOfFilter<>(0, filter1));
        assertThrows(IllegalArgumentException.class, () -> new AtLeastNOfFilter<>(-1, filter1));
        assertThrows(IllegalArgumentException.class, () -> new AtLeastNOfFilter<>(-10, filter1));
    }

    /**
     * Test that the filter passes if at least exactly n child filters pass.
     */
    @Test
    public void passIfExactlyOnePasses(){
        when(filter1.passes(1)).thenReturn(false);
        when(filter2.passes(1)).thenReturn(false);
        when(filter3.passes(1)).thenReturn(true);
        when(filter4.passes(1)).thenReturn(false);

        AtLeastNOfFilter<Integer> atLeastNOfFilter = new AtLeastNOfFilter<>(1, filter1, filter2, filter3, filter4);
        assertTrue(atLeastNOfFilter.passes(1));
    }

    /**
     * Test that the filter fails if at most n-1 child filters pass.
     */
    @Test
    public void FailsIfnMinusOnePasses(){
        when(filter1.passes(1)).thenReturn(true);
        when(filter2.passes(1)).thenReturn(true);
        when(filter3.passes(1)).thenReturn(true);
        when(filter4.passes(1)).thenReturn(false);

        AtLeastNOfFilter<Integer> atLeastNOfFilter = new AtLeastNOfFilter<>(4, filter1, filter2, filter3, filter4);
        assertFalse(atLeastNOfFilter.passes(1));
    }
}