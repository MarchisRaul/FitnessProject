package TestPackage;

import BusinessLogicLayerPackage.UserBLL;
import DAOlayerPackage.UserDAO;
import ModelsLayerPackage.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestUser {
    UserBLL userBLL = null;

    @Mock
    UserDAO userDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        userBLL = new UserBLL(userDAO);
    }

    @Test
    public void testFindUserById() {
        when(userDAO.findById(2)).thenReturn(new User(2, "Jamaicana", 1, 21, "7card","", -1, -1));
        assertEquals("Jamaicana", userBLL.findById(2).getName());
        verify(userDAO).findById(2);
    }
}
