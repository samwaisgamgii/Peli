/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
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
import teos.ohjaaja.Ohjaus;

/**
 * hoitaa piirtämis algoritmit.
 *
 * @author Sami
 */
public class Piirtopaneeli extends JPanel implements ActionListener {

    private JFrame j;
    private String data;
    private Naytto n;
    private Timer time;
    private Ohjaus o;
    Graphics2D g2d;

    private boolean eka = true;
    private boolean outo = false, rajahdus = false, cC = false, cSin = false, matrix = true, sin = false;
    private ArrayList lista = new ArrayList();
    private ArrayList listaSin = new ArrayList();

    private int red, green, blue, poistettuTyh = 0;
    private int delay = 6;
    private int b = 0, tyhja = 0, m = 0;
    private int t = 0, redS, blueS, w, h, valmis = 0, monesX = 10, monesY = 20;

    private char dataS = ' ', dataC = ' ';
    private String tyh = "";

    /**
     * konstruktori.
     */
    public Piirtopaneeli() {

    }

    /**
     * Ajastaa.
     *
     * @param jf Jframe
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
     * Hallinnoi piirto asetuksia.
     *
     * @param g grafiikka
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
        if (rajahdus == true) {
            rajahdus(g, 0);
        }
        if (outo == true) {
            rajahdus(g, 1);
        }

    }

    /**
     * hoitaa rajahdyksen ja pallon hallinoinnin.
     *
     * @param g grafiikka
     * @param outo 1 jos haluaa oudon räjähdyksen muuten 0
     */
    public void rajahdus(Graphics g, int outo) {
        g2d = (Graphics2D) g;
        g2d.setColor(variAnimaatio());

        if (eka == true) {
            time.setDelay(4);

            randomSijaintiLista(outo);
            o.piirraPallo(g, w, h, 1);
        }
        o.piirraPallo(g, w, h, 2);
        for (int i = 0; i < listaSin.size() - 5; i = i + 5) {
            int x = (int) listaSin.get(i + 1);
            int y = (int) listaSin.get(i + 3);
            g2d.drawString((String) listaSin.get(i), x, y);
            tarkastaOnkoSisalla(x, y, i);

        }
        paivitaSijainti();
        peliLoppu(g);

    }

    /**
     * tarkistaa onko kirjain sisällä ja poistaa kirjaimen jos on.
     *
     * @param x sijainti
     * @param y sijainti
     * @param i listan alkio
     */
    public void tarkastaOnkoSisalla(int x, int y, int i) {
        if (o.tarkastaOnkoSisalla(x, y)) {
            tyh = (String) listaSin.get(i);
            if (tyh.equals(" ")) {
                poistettuTyh++;
            }
            listaSin.remove(i);
            listaSin.remove(i);
            listaSin.remove(i);
            listaSin.remove(i);
            listaSin.remove(i);

        }
    }

    /**
     * Luo 'peli loppu' ilmoituksen.
     *
     * @param g grafiikka
     */
    public void peliLoppu(Graphics g) {

        if (listaSin.size() - poistettuTyh <= 0) {
            g2d = (Graphics2D) g;
            g2d.setFont(new Font("Courier New", 1, 30));
            g2d.drawString("Paina 'R' pelataksesi uudelleen.", w / 3, h / 2);

        }

    }

    /**
     * paivittaa x ja y sijainnin datalle.
     *
     */
    public void paivitaSijainti() {

        for (int i = 1; i < listaSin.size() - 5; i = i + 5) {

            paivitaX(i);
            paivitaY(i);

        }
    }

    /**
     * päivittää y sijainnin listaan.
     *
     * @param i alkion numero
     */
    public void paivitaY(int i) {
        int yr, yspeed, yrspeed;
        yr = (int) listaSin.get(i + 2);
        yspeed = (int) listaSin.get(i + 3);
        yrspeed = yr + yspeed;
        if (yrspeed < 0 || yrspeed >= h) {
            yrspeed = -yrspeed * (int) ((Math.random() * 5) - 1);
            listaSin.set(i + 2, yrspeed);

        } else {
            listaSin.set(i + 2, yrspeed);
        }

    }

    /**
     * päivittää X sijainnin listaan.
     *
     * @param i alkion numero
     */
    public void paivitaX(int i) {
        int xr, xspeed, xrspeed;
        xr = (int) listaSin.get(i);
        xspeed = (int) listaSin.get(i + 1);
        xrspeed = xr + xspeed;
        if (xrspeed < 0 || xrspeed >= w) {
            xrspeed = -xrspeed * (int) ((Math.random() * 5) - 1);
            listaSin.set(i, xrspeed);
        } else {
            listaSin.set(i, xrspeed);
        }

    }

    /**
     * Vie random sijainnit ja nopeudet listaan.
     *
     * @param outo 0 tai 1 riippuen haluttavasta moodista
     */
    public void randomSijaintiLista(int outo) {
        int xr, yr, xspeed, yspeed;
        char datar;
        for (int i = 0; i < data.length(); i++) {
            datar = data.charAt(i);
            if (outo == 1) {
                xr = h / 2;
                yr = w / 2;

            } else {
                xr = (int) (Math.random() * w);
                yr = (int) (Math.random() * h);
            }

            xspeed = (int) ((Math.random() * 5) - 2);
            yspeed = (int) ((Math.random() * 5) - 2);
            listaSin.add(String.valueOf(datar));
            listaSin.add(xr);
            listaSin.add(xspeed);
            listaSin.add(yr);
            listaSin.add(yspeed);

        }
        eka = false;
    }

    /**
     * piirtää sin aallon.
     *
     * @param g grafiikka
     * @param s aallon tyyppi
     */
    public void piirraSinAalto(Graphics g, int s) {
        g2d = (Graphics2D) g;
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

    /**
     * vie sin arvot listaan.
     *
     */
    public void lisaaSinArvotListaan() {
        dataS = data.charAt(t);
        listaSin.add(String.valueOf(dataS));
        listaSin.add(redS);
        listaSin.add(blueS);
    }

    /**
     * Huolehtii piirto datan lisäämisesta ja toistosta.
     *
     * @param tyyppi huolehdittavan tilanteen tyyppi
     */
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

    /**
     * Arpoo sin arvot systeemin aikaa käyttäen.
     *
     * @param i aallon tyyppi: 1 , 2 tai 3
     */
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

    /**
     * arpoo värit systeemin aikaa käyttäen.
     *
     * @return uusi väri
     */
    public Color variAnimaatio() {
        double aika = System.currentTimeMillis();
        red = (int) ((2 + sin(aika * 0.001)) * 64);
        green = (int) ((2 + cos(aika * 0.002)) * 64);
        blue = (int) ((2 + sin(aika * 0.003)) * 64);
        Color uusi = new Color(red, green, blue);

        return uusi;
    }

    /**
     * piirtää kirjaimet yksitellen.
     *
     * @param g grafiikka
     */
    public void piirraGradualiisesti(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setColor(variAnimaatio());

        for (int i = 0; i <= m; i = i + 3) {
            g2d.drawString((String) lista.get(i), (int) lista.get(i + 1), (int) lista.get(i + 2));
        }
        lisaaJaReplay("m");
    }

    /**
     * huolehtii piirto "moden" vaihdosta.
     *
     * @param i piirto moodi 1,2,3,4,5 tai 6
     */
    public void sinM(int i) {
        if (i == 1) {
            listaSin.clear();
            t = 0;
            eka = true;
            outo = false;
            rajahdus = false;
            cSin = false;
            cC = false;
            matrix = false;
            sin = true;
        }
        if (i == 2) {
            listaSin.clear();
            t = 0;
            eka = true;
            rajahdus = false;
            outo = false;
            matrix = false;
            cC = false;
            sin = false;
            cSin = true;
        }
        if (i == 3) {
            listaSin.clear();
            t = 0;
            eka = true;
            rajahdus = false;
            matrix = false;
            outo = false;
            sin = false;
            cSin = false;
            cC = true;
        }
        if (i == 4) {
            listaSin.clear();
            t = 0;
            eka = true;
            matrix = false;
            sin = false;
            outo = false;
            cSin = false;
            cC = false;
            rajahdus = true;
        }
        if (i == 5) {
            listaSin.clear();
            t = 0;
            eka = true;
            sin = false;
            outo = false;
            cSin = false;
            cC = false;
            rajahdus = false;
            matrix = true;
        }
        if (i == 6) {
            listaSin.clear();
            t = 0;
            eka = true;
            sin = false;
            cSin = false;
            cC = false;
            rajahdus = false;
            matrix = false;
            outo = true;

        }

    }

    /**
     * asentaa piirrettävän datan ja näytön mitat.
     *
     * @param data piirrettävä data
     * @param o ohjaaja
     */
    public void asennaJaPiirra(String data, Ohjaus o) {
        this.o = o;
        this.data = data;
        this.w = j.getWidth();
        this.h = j.getHeight();

        lisaaDataListaan(data);

    }

    /**
     * tarkastaa että x ja y piirtyvät oikein näytölle.
     *
     *
     */
    public void tarkistaXjaY() {
        if (monesX >= w - 30) {
            monesX = 10;
            monesY = monesY + 20;
        }
        if (monesY >= h - 20) {
            monesY = 20;
        }

    }

    /**
     * lisää graduaali datan listaan.
     *
     * @param data string data
     */
    public void lisaaDataListaan(String data) {
        for (int i = 0; i < data.length(); i++) {
            tarkistaXjaY();
            dataC = data.charAt(i);
            monesX = monesX + 10;

            lista.add(String.valueOf(dataC));
            lista.add(monesX);
            lista.add(monesY);
        }

    }

    /**
     * asettaa näytön paneelille.
     *
     * @param n naytto
     */
    public void setNaytto(Naytto n) {
        this.n = n;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

}
