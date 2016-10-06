/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import teos.ohjaaja.Ohjaus;

/**
 *
 * @author Sami
 */
public class Naytto implements KeyListener {

    private JFrame ikkuna = new JFrame();
    private JPanel taulu;
    Ohjaus ohjaus;

    public Naytto() {

    }

    public void luoIkkuna(Color vari) {
        ikkuna.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ikkuna.setUndecorated(true);
        taulu = new Piirtopaneeli(ikkuna);
        taulu.setBackground(vari);
        ohjaus.setJPanel((Piirtopaneeli) taulu);
        ikkuna.add(taulu);
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setVisible(true);
        ikkuna.addKeyListener(this);

    }

    public void setOhjaus(Ohjaus ohjaus) {
        this.ohjaus = ohjaus;
    }

    public void ilmoitaVirhe(String virhe) {
        JOptionPane.showMessageDialog(ikkuna, virhe,
                "Error",
                JOptionPane.ERROR_MESSAGE);
        ohjaus.lueTarkistaPiirra();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            ohjaus.escPainettu();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public JFrame getIkkuna() {
        return ikkuna;
    }

    public void setIkkuna(JFrame ikkuna) {
        this.ikkuna = ikkuna;
    }

    public JPanel getTaulu() {
        return taulu;
    }

    public void setTaulu(JPanel taulu) {
        this.taulu = taulu;
    }

}
