import Model.Model;
import Utile.Exceptie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrarePolinoameTest {
    @Test
    public void integrarePolinoame() throws Exceptie { Model model=new Model();
        model.checkPolinom("2X^2+X+3",1);
        assertEquals(model.integrare(), "2/3X^3+1/2X^2+3X");
    }
}
