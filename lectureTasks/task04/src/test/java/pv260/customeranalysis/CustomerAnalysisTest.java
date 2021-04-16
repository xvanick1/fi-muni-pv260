package pv260.customeranalysis;

import static com.googlecode.catchexception.CatchException.catchException;

import org.junit.Test;
import pv260.customeranalysis.entities.Product;
import pv260.customeranalysis.exceptions.CantUnderstandException;
import pv260.customeranalysis.exceptions.GeneralException;
import pv260.customeranalysis.interfaces.AnalyticalEngine;
import pv260.customeranalysis.interfaces.ErrorHandler;
import pv260.customeranalysis.interfaces.NewsList;
import pv260.customeranalysis.interfaces.Storage;

import java.util.Collections;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * @author Jozef Vanický
 */

public class CustomerAnalysisTest {

    /**
     * Verify the ErrorHandler is invoked when one of the AnalyticalEngine methods
     * throws exception and the exception is not re-thrown from the CustomerAnalysis.
     * The exception is passed to the ErrorHandler directly, not wrapped.
     */
    @Test
    public void testErrorHandlerInvokedWhenEngineThrows() throws GeneralException {
        ErrorHandler handler= mock(ErrorHandler.class);
        AnalyticalEngine engine= mock(AnalyticalEngine.class);
        Product product= mock(Product.class);
        when(engine.interesetingCustomers(product)).thenThrow(new CantUnderstandException());

        Storage storage = mock(Storage.class);
        NewsList newsList = mock(NewsList.class);

        CustomerAnalysis analysis= new CustomerAnalysis(Collections.singletonList(engine),storage, newsList,handler);

        catchException(() ->analysis.findInterestingCustomers(product));

        verify(handler).handle(isA(CantUnderstandException.class));
    }

    /**
     * Verify that if first AnalyticalEngine fails by throwing an exception,
     * subsequent engines are tried with the same input.
     * Ordering of engines is given by their order in the List passed to
     * constructor of AnalyticalEngine
     */
    @Test
    public void testSubsequentEnginesTriedIfOneFails() throws GeneralException {
    }

    /**
     * Verify that as soon as the first AnalyticalEngine succeeds,
     * this result is returned as result and no subsequent
     * AnalyticalEngine is invoked for this input
     */
    @Test
    public void testNoMoreEnginesTriedAfterOneSucceeds() throws GeneralException {
    }

    /**
     * Verify that once Offer is created for the Customer,
     * this order is persisted in the Storage before being
     * added to the NewsList
     * HINT: you might use mockito InOrder
     */
    @Test
    public void testOfferIsPersistedBeforeAddedToNewsList() throws GeneralException {
    }

    /**
     * Verify that Offer is created for every selected Customer for the given Product
     * test with at least two Customers selected by the AnalyticalEngine
     * HINT: you might use mockito ArgumentCaptor
     */
    @Test
    public void testOfferContainsProductAndCustomer() throws GeneralException {
    }

}
