package Model;

import Utile.Exceptie;
import Utile.Monom;
import Utile.Polinom;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    private final Polinom polinom1 = new Polinom();
    private final Polinom polinom2 = new Polinom();
    private final Polinom rezultat = new Polinom();

    public void checkPolinom(String a, int x) throws Exceptie {
        if ((a.equals(" ")) || (a.equals("")))
            throw new Exceptie("Polinom invalid");
        if (x == 1) {
            this.polinom1.deleteAll();
            this.polinom2.deleteAll();
            this.rezultat.deleteAll();
        }

        Pattern pattern1 = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher1 = pattern1.matcher(a);
        Pattern pattern2 = Pattern.compile(("[+-]?[0-9]*([Xx])?\\^?[0-9]*"));
        Matcher matcher2;
        while (matcher1.find()) {
            matcher2 = pattern2.matcher(matcher1.group(1));
            if (!matcher2.matches())
                throw new Exceptie("Polinom invalid");

            checkPolinomUtil(x, matcher1);
        }
    }

    private void checkPolinomUtil(int x, Matcher matcher1) {
        int i = 0;
        int validareGrad = 0;
        int grad = 0;
        int coeficient = 0;
        int operatie = 1;
        int valZero = 0;
        while ((i < matcher1.group(1).length()) && (matcher1.group(1).charAt(i) != 'x') && (matcher1.group(1).charAt(i) != 'X')) {
            if ((matcher1.group(1).charAt(i) >= '0') && (matcher1.group(1).charAt(i) <= '9')) {
                if (matcher1.group(1).charAt(i) == '0') {
                    if (i == 0) {
                        if (i + 1 < matcher1.group(1).length()) {
                            if (matcher1.group(1).charAt(i + 1) < '1' || matcher1.group(1).charAt(i + 1) > '9')
                                valZero = 1;
                        } else
                            valZero = 1;

                    } else {
                        if (i + 1 < matcher1.group(1).length()) {
                            if ((matcher1.group(1).charAt(i + 1) < '1' || matcher1.group(1).charAt(i + 1) > '9') && (matcher1.group(1).charAt(i - 1) < '1' ||
                                    matcher1.group(1).charAt(i - 1) > '9'))
                                valZero = 1;
                        } else {
                            if (matcher1.group(1).charAt(i - 1) < '1' || matcher1.group(1).charAt(i - 1) > '9')
                                valZero = 1;
                        }
                    }

                }

                if (i != 0) {
                    if (matcher1.group(1).charAt(i - 1) == '-')
                        operatie = 0;
                }
                if (operatie == 1)
                    coeficient = coeficient * 10 + (matcher1.group(1).charAt(i) - 48);
                else
                    coeficient = coeficient * 10 - (matcher1.group(1).charAt(i) - 48);


            }

            i++;
        }

        while (i < matcher1.group(1).length()) {
            if ((matcher1.group(1).charAt(i) == 'X') || (matcher1.group(1).charAt(i) == 'x'))
                validareGrad = 1;
            if ((matcher1.group(1).charAt(i) >= '0') && (matcher1.group(1).charAt(i) <= '9'))
                grad = grad * 10 + (matcher1.group(1).charAt(i) - 48);


            i++;

        }
        if ((grad == 0) && (validareGrad == 1))
            grad = 1;
        if (coeficient == 0) {
            if (valZero == 0) {
                if (matcher1.group(1).charAt(0) == '-')
                    coeficient = -1;
                else
                    coeficient = 1;
            }
        }
        if (x == 1)
            this.polinom1.addElement(coeficient, grad, 1);
        if (x == 2)
            this.polinom2.addElement(coeficient, grad, 1);

    }

    public Polinom adunareSauScadere(Polinom polinom1, Polinom polinom2, int x, int mod) {
        int indexPol1 = 0;
        int indexPol2 = 0;
        if (mod == 1) {
            polinom1 = this.polinom1;
            polinom2 = this.polinom2;
        }

        while ((indexPol1 < polinom1.getElemente().size()) && (indexPol2 < polinom2.getElemente().size())) {
            if (polinom1.getElemente().get(indexPol1).getGrad() > polinom2.getElemente().get(indexPol2).getGrad()) {
                rezultat.addElement(polinom1.getElemente().get(indexPol1).getCoeficient(), polinom1.getElemente().get(indexPol1).getGrad(), 1);
                indexPol1++;
            } else {
                if (polinom1.getElemente().get(indexPol1).getGrad() < polinom2.getElemente().get(indexPol2).getGrad()) {
                    if (x == 1)
                        rezultat.addElement(polinom2.getElemente().get(indexPol2).getCoeficient(), polinom2.getElemente().get(indexPol2).getGrad(), 1);
                    else
                        rezultat.addElement(-polinom2.getElemente().get(indexPol2).getCoeficient(), polinom2.getElemente().get(indexPol2).getGrad(), 1);
                    indexPol2++;
                } else {
                    if (polinom1.getElemente().get(indexPol1).getGrad() == polinom2.getElemente().get(indexPol2).getGrad()) {
                        if (x == 1)
                            rezultat.addElement(polinom1.getElemente().get(indexPol1).getCoeficient() + polinom2.getElemente().get(indexPol2).getCoeficient(), polinom1.getElemente().get(indexPol1).getGrad(), 1);
                        else
                            rezultat.addElement(polinom1.getElemente().get(indexPol1).getCoeficient() - polinom2.getElemente().get(indexPol2).getCoeficient(), polinom1.getElemente().get(indexPol1).getGrad(), 1);
                        indexPol1++;
                        indexPol2++;
                    }
                }
            }
        }

        while (indexPol1 < polinom1.getElemente().size()) {
            rezultat.addElement(polinom1.getElemente().get(indexPol1).getCoeficient(), polinom1.getElemente().get(indexPol1).getGrad(), 1);
            indexPol1++;
        }

        while (indexPol2 < polinom2.getElemente().size()) {
            if (x == 1)
                rezultat.addElement(polinom2.getElemente().get(indexPol2).getCoeficient(), polinom2.getElemente().get(indexPol2).getGrad(), 1);
            else
                rezultat.addElement(-polinom2.getElemente().get(indexPol2).getCoeficient(), polinom2.getElemente().get(indexPol2).getGrad(), 1);
            indexPol2++;
        }
        for (int i = 0; i < rezultat.getElemente().size(); i++)
            if (rezultat.getElemente().get(i).getCoeficient() == 0)
                rezultat.getElemente().remove(i);
        return rezultat;

    }

    public String derivare() {
        for (Monom i : polinom1.getElemente())
            if (i.getGrad() > 0)
                rezultat.addElement(i.getCoeficient() * i.getGrad(), i.getGrad() - 1, 1);


        return rezultat.toString();
    }

    public String integrare() {
        for (Monom i : polinom1.getElemente())
            rezultat.addElement(i.getCoeficient() / celMaiMareDivizorComun(i.getCoeficient(), i.getGrad() + 1), i.getGrad() + 1, (i.getGrad() + 1) / celMaiMareDivizorComun(i.getCoeficient(), i.getGrad() + 1));


        return rezultat.toString();

    }

    public String inmultire() {
        Polinom aux = new Polinom();
        int coeficient;
        int grad;
        int ok;
        ArrayList<Integer> puteri = new ArrayList<>();

        for (Monom i : polinom1.getElemente()) {
            for (Monom j : polinom2.getElemente())
                aux.addElement(inmultireMonom(i, j).getCoeficient(), inmultireMonom(i, j).getGrad(), inmultireMonom(i, j).getNumitorCoeficient());
        }
        for (Monom i : aux.getElemente()) {
            coeficient = i.getCoeficient();
            grad = i.getGrad();
            ok = 1;
            for (Integer o : puteri)
                if (o == grad) {
                    ok = 0;
                    break;
                }
            if (ok == 1) {
                puteri.add(grad);
                for (Monom j : aux.getElemente())
                    if (grad == j.getGrad()) {
                        if (aux.getElemente().indexOf(j) != aux.getElemente().indexOf(i))
                            coeficient += j.getCoeficient();
                    }


                rezultat.addElement(coeficient, grad, 1);
            }

        }
        sortPolinom(rezultat);
        return rezultat.toString();
    }

    private int celMaiMareDivizorComun(int x1, int x2) {
        int a, b;
        a = x1;
        b = x2;
        if (a < 0)
            a = -a;
        if (b < 0)
            b = -b;

        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    private Monom inmultireMonom(Monom a, Monom b) {
        return new Monom(a.getCoeficient() * b.getCoeficient(), a.getGrad() + b.getGrad(), 1);

    }

    private void sortPolinom(Polinom a) {
        for (int i = 0; i < a.getElemente().size() - 1; i++) {
            for (int j = i + 1; j < a.getElemente().size(); j++)
                if (a.getElemente().get(j).getGrad() > a.getElemente().get(i).getGrad()) {
                    Monom aux = a.getElemente().get(i);
                    a.getElemente().set(i, a.getElemente().get(j));
                    a.getElemente().set(j, aux);
                }
        }
    }

    private Monom impartireMonom(Monom a, Monom b) {

        if (b.getCoeficient() < 0)
            return new Monom(-1 * (a.getCoeficient() / celMaiMareDivizorComun(a.getCoeficient(), b.getCoeficient())), a.getGrad() - b.getGrad(), 1);
        else
            return new Monom(a.getCoeficient() / celMaiMareDivizorComun(a.getCoeficient(), b.getCoeficient()), a.getGrad() - b.getGrad(), 1);

    }

    private Polinom inmUtilImpartire(Monom a, Polinom b) {
        Polinom aux = new Polinom();
        for (Monom i : b.getElemente()) {
            aux.addElement(a.getCoeficient() * i.getCoeficient(), a.getGrad() + i.getGrad(), 1);
        }
        return aux;
    }

    private Polinom extragereUtilImpartire(Polinom a, Polinom b) {
        sortPolinom(a);
        sortPolinom(b);
        int i;
        int j;
        int ok;
        Polinom rezultat = new Polinom();
        for (i = 0; i < a.getElemente().size(); i++) {
            ok = 0;
            for (j = 0; j < b.getElemente().size(); j++)
                if (a.getElemente().get(i).getGrad() == b.getElemente().get(j).getGrad()) {
                    rezultat.addElement(a.getElemente().get(i).getCoeficient() - b.getElemente().get(j).getCoeficient(), a.getElemente().get(i).getGrad(), 1);
                    ok = 1;
                }
            if (ok == 0)
                rezultat.addElement(a.getElemente().get(i).getCoeficient(), a.getElemente().get(i).getGrad(), 1);

        }
        for (i = 0; i < rezultat.getElemente().size(); i++)
            if (rezultat.getElemente().get(i).getCoeficient() == 0)
                rezultat.getElemente().remove(i);

        return rezultat;
    }

    private String operatiiImpartire(Polinom a, Polinom b) {
        Polinom polinomCat = new Polinom();
        while ((a.getGradPolinom() >= b.getGradPolinom()) && (0 != a.getElemente().get(0).getCoeficient())) {
            if (b.getElemente().get(0).getCoeficient() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Impartirea cu 0 nu este corecta din punct de vedere matematic",
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return "";
            }
            float s1 = (float) a.getElemente().get(0).getCoeficient() / b.getElemente().get(0).getCoeficient();
            int s2 = a.getElemente().get(0).getCoeficient() / b.getElemente().get(0).getCoeficient();
            if (s1 != s2) {
                JOptionPane.showMessageDialog(null,
                        "Rezultatul are coeficienti reali",
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return "";
            }
            Monom aux = impartireMonom(a.getElemente().get(0), b.getElemente().get(0));
            polinomCat.addElement(aux.getCoeficient(), aux.getGrad(), aux.getNumitorCoeficient());
            a = extragereUtilImpartire(a,
                    inmUtilImpartire(aux, b));
            if (a.getElemente().isEmpty()) {
                break;
            }

        }
        return "Cat: " + polinomCat.toString() + " Rest: " + a.toString();
    }

    public String impartire() {
        sortPolinom(polinom1);
        sortPolinom(polinom2);
        if (polinom1.getGradPolinom() == 0 && polinom2.getGradPolinom() == 0) {
            float s1 = (float) polinom1.getElemente().get(0).getCoeficient() / polinom2.getElemente().get(0).getCoeficient();
            int s2 = polinom1.getElemente().get(0).getCoeficient() / polinom2.getElemente().get(0).getCoeficient();
            if (s1 != s2) {
                JOptionPane.showMessageDialog(null,
                        "Rezultatul are coeficienti reali",
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return "";
            } else
                return ("Cat: " + polinom1.getElemente().get(0).getCoeficient() / polinom2.getElemente().get(0).getCoeficient() + " Rest: 0");
        } else {
            if (polinom1.getGradPolinom() >= polinom2.getGradPolinom())
                return operatiiImpartire(polinom1, polinom2);
            else
                return operatiiImpartire(polinom2, polinom1);
        }

    }


}
