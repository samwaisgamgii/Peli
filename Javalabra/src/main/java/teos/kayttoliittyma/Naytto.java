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
import teos.ohjaaja.Ohjaus;

/**
 *
 * @author Sami
 */
public class Naytto implements KeyListener {

    protected JFrame ikkuna = new JFrame();
    Ohjaus ohjaus;

    public Naytto() {

    }

    public void luoIkkuna(Color vari) {
        ikkuna.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ikkuna.setUndecorated(true);
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setVisible(true);
        ikkuna.getContentPane().setBackground(vari);
        ikkuna.addKeyListener(this);

    }

    public void setOhjaus(Ohjaus ohjaus) {
        this.ohjaus = ohjaus;
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

}
