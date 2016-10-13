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
 *
 * @author Sami
 */
public class Ohjaus {

    private TiedostonLuku lue;
    private String virhe;
    private Naytto naytto;
    private VirheetJaSiivous vs;
    private Piirtopaneeli p;
    private Pallo pa;

    public Ohjaus() {

    }

    public Ohjaus(Naytto n, TiedostonLuku l, VirheetJaSiivous vs) {
        this.naytto = n;
        this.lue = l;
        this.vs = vs;

    }

    public void aloitus() {
        naytto.setOhjaus(this);
        naytto.luoIkkuna(Color.BLACK);
        lueTarkistaPiirra();
    }

    /**
     * lukee, tarkistaa ja delegoi piirtämisen
     *
     *
     */
    public void lueTarkistaPiirra() {
        String data = lue.haeTiedosto();
        if (data.startsWith("virhe")) {
            virhe = data;
            naytto.ilmoitaVirhe(virhe);
        }else{
           p.asennaJaPiirra(data, this);  
        }
       
    }

    /**
     * välittää tiedon ohjelman sulusta
     *
     *
     */
    public void escPainettu() {
        vs.suljeOhjelma();
    }

    public void sinM(int i) {
        p.sinM(i);
    }

    public void piirraPallo(Graphics g, int w, int h, int eka) {
        if (eka == 1) {
            pa = new Pallo(w / 2, h / 2, 20);
            pa.setH(h);
            pa.setW(w);
            pa.drawP(g);
        }

        pa.drawP(g);

    }

    public boolean tarkastaOnkoSisalla(int x, int y) {
        return pa.onkoSisalla(x, y);
    }

    /**
     * valittaa liikkumis käskyn
     * @param x
     */
    public void liikuta(char x) {
        pa.liikutaS(x);

    }

    public String getVirhe() {
        return virhe;
    }

    public void setJPanel(Piirtopaneeli p) {
        this.p = p;
    }

}
