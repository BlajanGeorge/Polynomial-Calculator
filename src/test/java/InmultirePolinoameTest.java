import Model.Model;
import Utile.Exceptie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InmultirePolinoameTest {
    @Test
    public void inmultirePolinoame() throws Exceptie {
        Model model=new Model();
        model.checkPolinom("3X^2-X+1",1);
        model.checkPolinom("X-2",2);
        assertEquals(model.inmultire(), "3X^3-7X^2+3X-2");

    }
}
