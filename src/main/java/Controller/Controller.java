package Controller;

import Model.Model;
import Utile.Exceptie;
import View.View;

import javax.swing.*;


public class Controller {
    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.getBtnAdunare().addActionListener(e -> {
            try {
                this.model.checkPolinom(this.view.getPol1(), 1);
                this.model.checkPolinom(this.view.getPol2(), 2);
            } catch (Exceptie exceptie) {
                JOptionPane.showMessageDialog(null,
                        exceptie.getMessage(),
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.view.setRezultat(this.model.adunareSauScadere(null, null, 1, 1).toString());

        });

        this.view.getBtnScadere().addActionListener(e -> {
            try {
                this.model.checkPolinom(this.view.getPol1(), 1);
                this.model.checkPolinom(this.view.getPol2(), 2);
            } catch (Exceptie exceptie) {
                JOptionPane.showMessageDialog(null,
                        exceptie.getMessage(),
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.view.setRezultat(this.model.adunareSauScadere(null, null, 0, 1).toString());
        });
        this.view.getBtnInmultire().addActionListener(e -> {
            try {
                this.model.checkPolinom(this.view.getPol1(), 1);
                this.model.checkPolinom(this.view.getPol2(), 2);
            } catch (Exceptie exceptie) {
                JOptionPane.showMessageDialog(null,
                        exceptie.getMessage(),
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.view.setRezultat(this.model.inmultire());
        });
        this.view.getBtnImpartire().addActionListener(e -> {
            try {
                this.model.checkPolinom(this.view.getPol1(), 1);
                this.model.checkPolinom(this.view.getPol2(), 2);
            } catch (Exceptie exceptie) {
                JOptionPane.showMessageDialog(null,
                        exceptie.getMessage(),
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.view.setRezultat(this.model.impartire());
        });
        this.view.getBtnDerivare().addActionListener(e -> {
            try {
                this.model.checkPolinom(this.view.getPol1(), 1);

            } catch (Exceptie exceptie) {
                JOptionPane.showMessageDialog(null,
                        exceptie.getMessage(),
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.view.setRezultat(this.model.derivare());
        });
        this.view.getBtnIntegrare().addActionListener(e -> {
            try {
                this.model.checkPolinom(this.view.getPol1(), 1);

            } catch (Exceptie exceptie) {
                JOptionPane.showMessageDialog(null,
                        exceptie.getMessage(),
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.view.setRezultat(this.model.integrare());
        });

    }


}
