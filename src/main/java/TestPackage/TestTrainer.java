package TestPackage;

import BusinessLogicLayerPackage.TrainerBLL;
import DAOlayerPackage.TrainerDAO;
import ModelsLayerPackage.Trainer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestTrainer {
    TrainerBLL trainerBLL = null;

    @Mock
    TrainerDAO trainerDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        trainerBLL = new TrainerBLL(trainerDAO);
    }

    @Test
    public void testFindUserById() {
        when(trainerDAO.findById(1)).thenReturn(new Trainer(1, "Raulucu", 1, 100));
        assertEquals("Raulucu", trainerBLL.findById(1).getName());
        verify(trainerDAO).findById(1);
    }
}
