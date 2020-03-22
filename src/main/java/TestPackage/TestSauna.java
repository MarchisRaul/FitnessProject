package TestPackage;

import BusinessLogicLayerPackage.SaunaBLL;
import DAOlayerPackage.SaunaDAO;
import ModelsLayerPackage.Sauna;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.Time;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestSauna {
    SaunaBLL saunaBLL = null;

    @Mock
    SaunaDAO saunaDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        saunaBLL = new SaunaBLL(saunaDAO);
    }

    @Test
    public void testFindSaunaById() {
        when(saunaDAO.findById(1)).thenReturn(new Sauna(3, 3, new Time(1, 45, 0), 100));
        assertEquals(100, saunaBLL.findById(1).getSize_number());
        verify(saunaDAO).findById(1);
    }
}
