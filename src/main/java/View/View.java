package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class View implements MouseListener {

    private final JTextField polTxt2;
    private final JTextField polTxt1;
    private final JTextField rezTxt;
    private final JButton btnAdunare;
    private final JButton btnScadere;
    private final JButton btnInmultire;
    private final JButton btnImpartire;
    private final JButton btnDerivare;
    private final JButton btnIntegrare;
    private final JFrame secondFrame = new JFrame();


    public View() {
        JFrame mainFrame = new JFrame("Calculator Polinoame");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(550, 100, 500, 500);
        mainFrame.setVisible(true);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        polTxt1 = new JTextField();
        polTxt1.setBounds(10, 61, 466, 20);
        contentPane.add(polTxt1);
        polTxt1.setColumns(10);

        JLabel lbl1 = new JLabel("Polinom 1:");
        lbl1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        lbl1.setBounds(197, 32, 96, 20);
        contentPane.add(lbl1);

        JLabel lbl2 = new JLabel("Polinom 2:");
        lbl2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        lbl2.setBounds(197, 125, 96, 20);
        contentPane.add(lbl2);

        polTxt2 = new JTextField();
        polTxt2.setColumns(10);
        polTxt2.setBounds(10, 155, 466, 20);
        contentPane.add(polTxt2);

        btnAdunare = new JButton("Adunare");
        btnAdunare.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAdunare.setBounds(63, 227, 100, 25);
        contentPane.add(btnAdunare);

        btnScadere = new JButton("Scadere");
        btnScadere.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnScadere.setBounds(315, 227, 100, 25);
        contentPane.add(btnScadere);

        btnInmultire = new JButton("Inmultire");
        btnInmultire.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnInmultire.setBounds(63, 272, 100, 25);
        contentPane.add(btnInmultire);

        btnImpartire = new JButton("Impartire");
        btnImpartire.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnImpartire.setBounds(315, 272, 100, 25);
        contentPane.add(btnImpartire);

        btnDerivare = new JButton("Derivare");
        btnDerivare.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDerivare.setBounds(63, 319, 100, 25);
        contentPane.add(btnDerivare);

        btnIntegrare = new JButton("Integrare");
        btnIntegrare.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnIntegrare.setBounds(315, 319, 100, 25);
        contentPane.add(btnIntegrare);

        JLabel lblRezultat = new JLabel("Rezultat:");
        lblRezultat.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        lblRezultat.setBounds(197, 357, 96, 20);
        contentPane.add(lblRezultat);

        rezTxt = new JTextField();
        rezTxt.setColumns(10);
        rezTxt.setBounds(10, 390, 466, 20);
        contentPane.add(rezTxt);

        this.btnDerivare.addMouseListener(this);
        this.btnIntegrare.addMouseListener(this);

        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setBounds(100, 100, 247, 125);
        secondFrame.setLocation(mainFrame.getLocation());
        JPanel contentPane2 = new JPanel();
        contentPane2.setBackground(Color.BLACK);
        contentPane2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        secondFrame.setContentPane(contentPane2);
        contentPane2.setLayout(null);

        JLabel lblNewLabel = new JLabel("<html>Acesta operatie ia in considerare <br>valoarea polinomului 1 si ignora<br>valoarea polinomului 2.</html>");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblNewLabel.setBounds(10, 0, 210, 91);
        contentPane2.add(lblNewLabel);


    }

    public JButton getBtnAdunare() {
        return this.btnAdunare;
    }

    public JButton getBtnScadere() {
        return this.btnScadere;
    }

    public JButton getBtnInmultire() {
        return this.btnInmultire;
    }

    public JButton getBtnImpartire() {
        return this.btnImpartire;
    }

    public JButton getBtnDerivare() {
        return this.btnDerivare;
    }

    public JButton getBtnIntegrare() {
        return this.btnIntegrare;
    }

    public String getPol1() {
        return this.polTxt1.getText();
    }

    public String getPol2() {
        return this.polTxt2.getText();
    }

    public void setRezultat(String s) {
        this.rezTxt.setText(s);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.secondFrame.setVisible(true);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.secondFrame.setVisible(false);

    }


}
