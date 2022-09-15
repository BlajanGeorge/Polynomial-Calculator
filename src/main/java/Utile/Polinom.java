package Utile;


import java.util.ArrayList;

public class Polinom {
    private final ArrayList<Monom> elemente = new ArrayList<>();

    public ArrayList<Monom> getElemente() {
        return this.elemente;
    }

    public void addElement(int coeficient, int grad, int numitorCoeficient) {
        this.elemente.add(new Monom(coeficient, grad, numitorCoeficient));
    }

    public void deleteAll() {
        this.elemente.clear();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if (this.elemente.size() == 0)
            s = new StringBuilder("0");
        else {
            for (Monom i : this.elemente)
                if (i.getCoeficient() != 0) {
                    if (i.getGrad() == 0) {

                        if (i.getCoeficient() < 0) {
                            if (i.getNumitorCoeficient() != 1)
                                s.append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient());
                            else
                                s.append(+i.getCoeficient());
                        } else {
                            if (i.getGrad() == this.elemente.get(0).getGrad()) {
                                if (i.getNumitorCoeficient() != 1)
                                    s.append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient());
                                else
                                    s.append(i.getCoeficient());
                            } else {
                                if (i.getNumitorCoeficient() != 1)
                                    s.append("+").append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient());
                                else
                                    s.append("+").append(i.getCoeficient());
                            }
                        }
                    }
                    if (i.getGrad() == 1) {
                        if (i.getCoeficient() == 1) {
                            if (i.getGrad() == this.elemente.get(0).getGrad()) {
                                if (i.getNumitorCoeficient() != 1)
                                    s.append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X");
                                else
                                    s.append("X");
                            } else {
                                if (i.getNumitorCoeficient() != 1)
                                    s.append("+").append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X");
                                else
                                    s.append("+" + "X");
                            }
                        } else {
                            if (i.getCoeficient() < 0) {
                                if (i.getNumitorCoeficient() != 1)
                                    s.append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X");
                                else if (i.getCoeficient() == -1)
                                    s.append("-").append("X");
                                else
                                    s.append(+i.getCoeficient()).append("X");

                            } else {
                                if (i.getGrad() == this.elemente.get(0).getGrad()) {
                                    if (i.getNumitorCoeficient() != 1)
                                        s.append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X");
                                    else
                                        s.append(i.getCoeficient()).append("X");
                                } else {
                                    if (i.getNumitorCoeficient() != 1)
                                        s.append("+").append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X");
                                    else
                                        s.append("+").append(i.getCoeficient()).append("X");
                                }

                            }
                        }
                    }

                    if ((i.getGrad() != 0) && (i.getGrad() != 1)) {
                        if (i.getCoeficient() == 1) {
                            if (i.getNumitorCoeficient() != 1) {
                                if (i.getGrad() == this.elemente.get(0).getGrad())
                                    s.append(+i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X^").append(i.getGrad());
                                else
                                    s.append("+").append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X^").append(i.getGrad());
                            } else {
                                if (i.getGrad() == this.elemente.get(0).getGrad())
                                    s.append("X^").append(i.getGrad());
                                else
                                    s.append("+" + "X^").append(i.getGrad());

                            }
                        } else {
                            if (i.getCoeficient() < 0) {
                                if (i.getNumitorCoeficient() != 1)
                                    s.append(+i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X^").append(i.getGrad());
                                else if (i.getCoeficient() == -1)
                                    s.append("-").append("X^").append(i.getGrad());
                                else
                                    s.append(+i.getCoeficient()).append("X^").append(i.getGrad());
                            } else {
                                if (i.getGrad() == this.elemente.get(0).getGrad()) {
                                    if (i.getNumitorCoeficient() != 1)
                                        s.append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X^").append(i.getGrad());
                                    else
                                        s.append(i.getCoeficient()).append("X^").append(i.getGrad());
                                } else {
                                    if (i.getNumitorCoeficient() != 1)
                                        s.append("+").append(i.getCoeficient()).append("/").append(i.getNumitorCoeficient()).append("X^").append(i.getGrad());
                                    else
                                        s.append("+").append(i.getCoeficient()).append("X^").append(i.getGrad());
                                }

                            }
                        }

                    }
                }
        }


        return s.toString();
    }

    public int getGradPolinom() {
        if (this.elemente.isEmpty())
            return 0;
        return this.elemente.get(0).getGrad();
    }
}

