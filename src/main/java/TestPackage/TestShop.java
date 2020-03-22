package TestPackage;

import BusinessLogicLayerPackage.ShopBLL;
import DAOlayerPackage.ShopDAO;
import ModelsLayerPackage.Shop;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestShop {
    ShopBLL shopBLL = null;

    @Mock
    ShopDAO shopDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        shopBLL = new ShopBLL(shopDAO);
    }

    @Test
    public void testFindShopById() {
        when(shopDAO.findById(2)).thenReturn(new Shop(2, 10));
        assertEquals(10, shopBLL.findById(2).getDiscount_mode());
        verify(shopDAO).findById(2);
    }
}
