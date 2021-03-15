package Utile;

public class Monom {
    private final int coeficient;
    private final int grad;
    private final int numitorCoeficient;

    public Monom(int coeficient, int grad, int numitorCoeficient) {
        this.coeficient = coeficient;
        this.grad = grad;
        this.numitorCoeficient = numitorCoeficient;
    }

    public int getCoeficient() {
        return this.coeficient;
    }

    public int getGrad() {
        return this.grad;
    }

    public int getNumitorCoeficient() {
        return this.numitorCoeficient;
    }
}
