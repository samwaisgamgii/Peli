/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
    private Piirtopaneeli taulu;
    private int chooser;
    Ohjaus ohjaus;

    public Naytto() {

    }

    /**
     * Metodi kertoo luo ikkunan
     *
     * @param vari hardcoded
     *
     *
     */
    public void luoIkkuna(Color vari) {

        //ikkuna.setBounds(500, 500, 1600, 900);
        ikkuna.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // ikkuna.setLocationRelativeTo(null);
        ikkuna.setUndecorated(true);
        taulu = new Piirtopaneeli(ikkuna);
        taulu.setNaytto(this);
        taulu.setBackground(vari);
        ohjaus.setJPanel(taulu);
        ikkuna.add(taulu);
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setVisible(true);
        ikkuna.addKeyListener(this);

    }

    /**
     * luo guin polun määrittelemiseen
     *
     */
    public String polkuGui() {
        JButton avaa = new JButton();

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(null);
        fc.setDialogTitle("Kerro missä tiedostot ovat");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(avaa) == JFileChooser.APPROVE_OPTION) {
            chooser = 1;
        }
        String polku = fc.getSelectedFile().getAbsolutePath();
        return polku;
    }

    public void setOhjaus(Ohjaus ohjaus) {
        this.ohjaus = ohjaus;
    }

    /**
     * Metodi kertoo mikä on onnistumistodennäköisyys syöteluvulla ottaen
     * huomioon olion konstruktorissa asetetun kalibrointiarvon.
     *
     * @param virhe ilmoitettava virhe
     */
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
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ohjaus.liikuta('y');
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ohjaus.liikuta('a');
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ohjaus.liikuta('e');
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ohjaus.liikuta('t');
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {

            ohjaus.sinM(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_C) {

            ohjaus.sinM(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_V) {

            ohjaus.sinM(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {

            ohjaus.sinM(4);
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {

            ohjaus.sinM(5);
        }
        if (e.getKeyCode() == KeyEvent.VK_O) {

            ohjaus.sinM(6);
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

    public void setTaulu(Piirtopaneeli taulu) {
        this.taulu = taulu;
    }

}
