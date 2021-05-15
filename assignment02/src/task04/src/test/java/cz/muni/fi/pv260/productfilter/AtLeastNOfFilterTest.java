package cz.muni.fi.pv260.productfilter;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtLeastNOfFilterTest {

    @Mock
    Filter filter;


    @Test
    public void filterNeverSucceedsConstructorTest() {
        assertThrows(FilterNeverSucceeds.class, () -> new AtLeastNOfFilter<Integer>(2, filter));
    }

}