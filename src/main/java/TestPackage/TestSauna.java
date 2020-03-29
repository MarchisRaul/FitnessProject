package TestPackage;

import BusinessLogicLayerPackage.SaunaBLL;
import BusinessLogicLayerPackage.UserBLL;
import DAOlayerPackage.SaunaDAO;
import DAOlayerPackage.UserDAO;
import ModelsLayerPackage.Sauna;
import ModelsLayerPackage.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.Time;
import java.util.List;

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

    @Test
    public void testObserverPattern() {
        SaunaBLL saunaBLL = new SaunaBLL(new SaunaDAO());
        UserBLL userBLL = new UserBLL(new UserDAO());
        List<User> users = userBLL.findAllClients();
        for (User currentUser : users) {
            saunaBLL.addObserver(currentUser);
        }

        saunaBLL.insertSauna(new Sauna(13, 0, new Time(1, 45, 0), 10));
        assertEquals("a", "a");
    }
}
