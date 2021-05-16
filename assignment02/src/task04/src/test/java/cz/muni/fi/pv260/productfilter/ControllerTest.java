package cz.muni.fi.pv260.productfilter;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.*;
import static org.mockito.Mockito.*;

public class ControllerTest {
    @Mock
    Output output = mock(Output.class);

    @Mock
    Input input = mock(Input.class);

    @Mock
    Filter filter1 = mock(Filter.class);

    @Mock
    Logger logger = mock(Logger.class);

    @Mock
    Product product1 = mock(Product.class), product2 = mock(Product.class), product3 = mock(Product.class), product4 = mock(Product.class);

    @Mock
    ObtainFailedException obtainFailedException = mock(ObtainFailedException.class);

    @Test
    public void testSuccessSelectProductFilter() throws ObtainFailedException {
        Collection<Product> collections = new HashSet();
        collections.add(product1);

        when(input.obtainProducts()).thenReturn(Arrays.asList(product1));
        when(filter1.passes(product1)).thenReturn(true);

        Controller controller = new Controller(input,output,logger);
        controller.select(filter1);

        verify(logger).setLevel("INFO");
        verify(logger).log(Controller.TAG_CONTROLLER, "Successfully selected 1 out of 1 available products.");

    }

    @Test
    public void testSelectProductFilter() throws ObtainFailedException {
        Collection<Product> collections = new HashSet();
        collections.add(product1);
        collections.add(product2);
        collections.add(product3);
        collections.add(product4);

        when(input.obtainProducts()).thenReturn(Arrays.asList(product1,product2,product3,product4));
        when(filter1.passes(product1)).thenReturn(true);
        when(filter1.passes(product2)).thenReturn(false);
        when(filter1.passes(product3)).thenReturn(false);
        when(filter1.passes(product4)).thenReturn(true);

        Controller controller = new Controller(input,output,logger);
        controller.select(filter1);

        verify(output).postSelectedProducts(Arrays.asList(product1,product4));
    }

    @Test
    public void productExceptionNothingIsPassedTest() throws ObtainFailedException {
        when(input.obtainProducts()).thenThrow(ObtainFailedException.class);

        Controller controller = new Controller(input,output,logger);
        controller.select(filter1);

        verify(logger).setLevel("ERROR");
        verify(logger).log(Controller.TAG_CONTROLLER, "Filter procedure failed with exception: cz.muni.fi.pv260.productfilter.ObtainFailedException");
    }
}
