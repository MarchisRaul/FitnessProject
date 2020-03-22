package TestPackage;

import BusinessLogicLayerPackage.ProductBLL;
import DAOlayerPackage.ProductDAO;
import ModelsLayerPackage.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestProduct {
    ProductBLL productBLL = null;

    @Mock
    ProductDAO productDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        productBLL = new ProductBLL(productDAO);
    }

    @Test
    public void testFindProductById() {
        when(productDAO.findById(1)).thenReturn(new Product(1, "Raul", 2, "Muscle gains", 250, 10));
        assertEquals("Muscle gains", productBLL.findById(1).getUtility());
        verify(productDAO).findById(1);
    }
}
