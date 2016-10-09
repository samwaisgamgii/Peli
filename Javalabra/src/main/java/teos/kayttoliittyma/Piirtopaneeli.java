/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Sami
 */
public class Piirtopaneeli extends JPanel implements ActionListener {

    private JFrame j;
    private int delay = 3;
    private String data;
    private Naytto n;
    private boolean eka = true;
    private int red, green, blue;
    private Timer time;
    private boolean cC = false, cSin = false, matrix = true, sin = false;
    private ArrayList lista = new ArrayList();
    private ArrayList listaSin = new ArrayList();
    int m = 0;
    private int t = 0, redS, blueS, x, y, w, h, valmis = 0, monesX = 10, monesY = 20;

    private char dataS = ' ', dataC = ' ';

    public Piirtopaneeli() {

    }

    /**
     * Ajastaa
     *
     *
     */
    public Piirtopaneeli(JFrame jf) {
        j = jf;
        time = new Timer(delay, this);
        time.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirtele(g);

    }

    /**
     * hoitaa kahden moden piirtämisen
     *
     * @param g Käyttäjän antama syöte
     *
     *
     */
    public void piirtele(Graphics g) {

        if (data != null && matrix == true) {
            piirraGradualiisesti(g);

        }
        if (sin == true) {
            piirraSinAalto(g, 1);

        }
        if (cSin == true) {
            piirraSinAalto(g, 2);

        }
        if (cC == true) {
            piirraSinAalto(g, 3);

        }

    }

    public void piirraSinAalto(Graphics g, int s) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(variAnimaatio());
        sinAalto(s);

        if (eka == true) {
            lisaaSinArvotListaan();
        }
        for (int i = 0; i <= t; i = i + 3) {
            g2d.drawString((String) listaSin.get(i), (int) listaSin.get(i + 1), (int) listaSin.get(i + 2));
        }
        lisaaJaReplay("t");

    }

    public void lisaaSinArvotListaan() {
        dataS = data.charAt(t);
        listaSin.add(String.valueOf(dataS));
        listaSin.add(redS);
        listaSin.add(blueS);
    }

    public void lisaaJaReplay(String tyyppi) {
        if (tyyppi.equals("t")) {
            if (t < data.length() - 3) {
                t++;
            } else {
                t = 0;
                eka = false;
            }

        }
        if (tyyppi.equals("m")) {
            if (m < lista.size() - 3) {
                m++;
            } else {
                m = 0;
            }

        }

    }

    public void sinAalto(int i) {
        if (i == 1) {
            double aika = System.currentTimeMillis();
            redS = (int) ((1 + sin(aika * 0.001)) * w / 2);
            blueS = (int) ((1 + sin(aika * 0.003)) * h / 2);
        }
        if (i == 3) {
            double aika = System.currentTimeMillis();
            redS = (int) ((1 + tan(aika * 0.001)) * w / 2);
            blueS = (int) ((1 + cos(aika * 0.003)) * h / 2);
        }
        if (i == 2) {
            double aika = System.currentTimeMillis();
            redS = (int) ((1 + cos(aika * 0.001)) * w / 2);
            blueS = (int) ((1 + sin(aika * 0.003)) * h / 2);
        }

    }

    public Color variAnimaatio() {
        double aika = System.currentTimeMillis();
        red = (int) ((2 + sin(aika * 0.001)) * 64);
        green = (int) ((2 + cos(aika * 0.002)) * 64);
        blue = (int) ((2 + sin(aika * 0.003)) * 64);
        Color uusi = new Color(red, green, blue);

        return uusi;
    }

    public void piirraGradualiisesti(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(variAnimaatio());

        for (int i = 0; i <= m; i = i + 3) {
            g2d.drawString((String) lista.get(i), (int) lista.get(i + 1), (int) lista.get(i + 2));
        }
        lisaaJaReplay("m");
    }

    public void sinM(int i) {
        if (i == 1) {
            listaSin.clear();
            t = 0;
            eka = true;
            cSin = false;
            cC = false;
            matrix = false;
            sin = true;
        }
        if (i == 2) {
            listaSin.clear();
            t = 0;
            eka = true;
            matrix = false;
            cC = false;
            sin = false;
            cSin = true;
        }
        if (i == 3) {
            listaSin.clear();
            t = 0;
            eka = true;
            matrix = false;
            sin = false;
            cSin = false;
            cC = true;
        }

    }

    /**
     * Liikuttaa neliötä joka seikkailele sokkelossa
     *
     * @param t Käyttäjän antama syöte
     *
     *
     */
    /**
     * laittaa datan arraylistaan
     *
     * @param data Käyttäjän antama syöte
     *
     *
     */
    public void piirraTeksti(String data) {
        this.data = data;
        w = j.getWidth();
        h = j.getHeight();
        x = w / 2;
        y = (h / 1) - 20;
        lisaaDataListaan(data);

    }

    public void lisaaDataListaan(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (monesX >= w - 30) {
                monesX = 10;
                monesY = monesY + 20;
            }
            if (monesY >= h - 20) {
                monesY = 20;
            }

            dataC = data.charAt(i);
            monesX = monesX + 10;

            lista.add(String.valueOf(dataC));
            lista.add(monesX);
            lista.add(monesY);
        }

    }

    public void setNaytto(Naytto n) {
        this.n = n;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

}
