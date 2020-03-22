package TestPackage;

import BusinessLogicLayerPackage.SportClassBLL;
import DAOlayerPackage.SportClassDAO;
import ModelsLayerPackage.SportClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestSportClass {
    SportClassBLL sportClassBLL = null;

    @Mock
    SportClassDAO sportClassDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        sportClassBLL = new SportClassBLL(sportClassDAO);
    }

    @Test
    public void testFindSportClassById() {
        when(sportClassDAO.findById(1)).thenReturn(new SportClass(1, "Kango jump", 1, 300));
        assertEquals("Kango jump", sportClassBLL.findById(1).getName());
        verify(sportClassDAO).findById(1);
    }
}
