/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.ohjaaja;

import teos.kayttoliittyma.Naytto;
import teos.logiikka.TiedostonLuku;
import java.awt.Color;
import java.awt.Graphics;

import teos.kayttoliittyma.Piirtopaneeli;
import teos.logiikka.Pallo;
import teos.logiikka.VirheetJaSiivous;

/**
 * Ohjaa ohjelmaa.
 *
 * @author Sami
 */
public class Ohjaus {

    private TiedostonLuku lue;
    private String virhe = "";
    private Naytto naytto;
    private VirheetJaSiivous vs;
    private Piirtopaneeli p;
    private Pallo pa;

    /**
     * konstruktori.
     */
    public Ohjaus() {

    }

    /**
     * paramitrillen konstruktori.
     *
     * @param n naytto
     * @param l tiedostonluku
     * @param vs virheetjaSiivous
     */
    public Ohjaus(Naytto n, TiedostonLuku l, VirheetJaSiivous vs) {
        this.naytto = n;
        this.lue = l;
        this.vs = vs;

    }

    /**
     * aloittaa ohjelman.
     *
     */
    public void aloitus() {
        naytto.setOhjaus(this);
        lue.setOhjaus(this);
        naytto.luoIkkuna(Color.BLACK);
        lueTarkistaPiirra();
    }

    /**
     * lukee, tarkistaa ja delegoi piirtämisen.
     *
     *
     */
    public void lueTarkistaPiirra() {
        String data = lue.haeTiedosto();
        if (data.startsWith("virhe")) {
            virhe = data;
            naytto.ilmoitaVirhe(virhe);
        } else {
            p.asennaJaPiirra(data, this);
        }

    }

    /**
     * luo io guin.
     *
     * @return palauttaa polun
     */
    public String luoGuiIO() {
        return naytto.polkuGui();
    }

    /**
     * välittää tiedon ohjelman sulusta.
     *
     *
     */
    public void escPainettu() {
        vs.suljeOhjelma();
    }

    /**
     * välittää kirjoitus moodin.
     *
     * @param i i
     */
    public void sinM(int i) {
        p.sinM(i);
    }

    /**
     * käskee kirjoittamaan palloja.
     *
     * @param g grafiikka
     * @param w naytön leveys
     * @param h naytön korkeus
     * @param eka ensimmäinen kerta
     */
    public void piirraPallo(Graphics g, int w, int h, int eka) {
        if (eka == 1) {
            pa = new Pallo(w / 2, h / 2, 20);
            pa.setH(h);
            pa.setW(w);
            pa.drawP(g);
        }

        pa.drawP(g);

    }

    /**
     * tarkistaa onko piste ympyrän sisällä.
     *
     * @param x x
     * @param y y
     * @return true or false
     */

    public boolean tarkastaOnkoSisalla(int x, int y) {
        return pa.onkoSisalla(x, y);
    }

    /**
     * valittaa liikkumis käskyn.
     *
     * @param x liikkumis-suunta ID
     */
    public void liikuta(char x) {
        if (x != ' ') {
            pa.liikutaS(x);
        }

    }

    public String getVirhe() {
        return virhe;
    }

    public void setJPanel(Piirtopaneeli p) {
        this.p = p;
    }

}
