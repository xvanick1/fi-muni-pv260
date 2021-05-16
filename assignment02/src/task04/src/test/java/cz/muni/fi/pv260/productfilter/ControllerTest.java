package cz.muni.fi.pv260.productfilter;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * @author Michal Zelenák, Jozef Vanický
 * @created 15.05.2021
 * @project pv260-assignment02-task03
 **/

public class ControllerTest {
    @Mock
    Output output;

    @Mock
    Input input;

    @Mock
    Filter<Product> filter;

    @Mock
    Logger logger;

    @Mock
    Product product1,
            product2,
            product3,
            product4;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test that the controller sends exactly the products selected by the provided filter to Output.
     * @throws ObtainFailedException Exception from Input
     */
    @Test
    public void testSelectProductFilter() throws ObtainFailedException {
        when(input.obtainProducts()).thenReturn(Arrays.asList(product1, product2, product3, product4));
        when(filter.passes(product1)).thenReturn(true);
        when(filter.passes(product2)).thenReturn(false);
        when(filter.passes(product3)).thenReturn(false);
        when(filter.passes(product4)).thenReturn(true);

        Controller controller = new Controller(input, output, logger);
        controller.select(filter);

        verify(output).postSelectedProducts(Arrays.asList(product1,product4));
    }

    /**
     * Test that the controller logs the message in documented format on success.
     * @throws ObtainFailedException Exception from input
     */
    @Test
    public void testSuccessSelectProductFilterLogs() throws ObtainFailedException {
        when(input.obtainProducts()).thenReturn(Collections.singletonList(product1));
        when(filter.passes(product1)).thenReturn(true);

        Controller controller = new Controller(input, output, logger);
        controller.select(filter);

        verify(logger).setLevel("INFO");
        verify(logger).log(Controller.TAG_CONTROLLER, "Successfully selected 1 out of 1 available products.");
    }

    /**
     * Test that if exception occurs when obtaining the Product data, Controller logs this exception.
     * @throws ObtainFailedException Exception from Input
     */
    @Test
    public void productExceptionControllerLogTest() throws ObtainFailedException {
        when(input.obtainProducts()).thenThrow(ObtainFailedException.class);

        Controller controller = new Controller(input, output, logger);
        controller.select(filter);

        verify(logger).setLevel("ERROR");
        verify(logger).log(Controller.TAG_CONTROLLER, "Filter procedure failed with exception: cz.muni.fi.pv260.productfilter.ObtainFailedException");
    }

    /**
     * Test that if exception occurs when obtaining the Product data, nothing is passed to the Output.
     * @throws ObtainFailedException Exception from Input
     */
    @Test
    public void productExceptionNothingIsPassedToOutputTest() throws ObtainFailedException {
        when(input.obtainProducts()).thenThrow(ObtainFailedException.class);

        Controller controller = new Controller(input, output, logger);
        controller.select(filter);

        verify(output, never()).postSelectedProducts(Mockito.any());
    }
}
