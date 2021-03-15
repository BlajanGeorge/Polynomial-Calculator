import Model.Model;
import Utile.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScaderePolinoameTest {

    @Test
    public void scaderePolinoame()
    {
        Model model=new Model();
        Polinom pol1=new Polinom();
        Polinom pol2=new Polinom();
        pol1.addElement(2,2,1);
        pol1.addElement(1,1,4);
        pol1.addElement(3,0,1);
        pol2.addElement(4,1,1);
        pol2.addElement(1,0,1);
        assertEquals(model.adunareSauScadere(pol1, pol2, 0, 0).toString(), "2X^2-3X+2");
    }
}
