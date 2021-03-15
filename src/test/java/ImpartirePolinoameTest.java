import Model.Model;
import Utile.Exceptie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImpartirePolinoameTest {

    @Test
    public void impartirePolinoame() throws Exceptie { Model model=new Model();
        model.checkPolinom("X^3-2X^2+6X-5",1);
        model.checkPolinom("X^2-1",2);
        assertEquals(model.impartire(),"Cat: X-2 Rest: 7X-7");

    }
}
