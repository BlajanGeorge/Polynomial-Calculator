import Model.Model;
import Utile.Exceptie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerivarePolinoame {


    @Test
    public void derivare() throws Exceptie { Model model=new Model();
        model.checkPolinom("2X^2+X+3",1);
        assertEquals(model.derivare(), "4X+1");

    }
}
