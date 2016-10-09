/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.ohjaaja;

import teos.kayttoliittyma.Naytto;
import teos.logiikka.TiedostonLuku;
import java.awt.Color;

import teos.kayttoliittyma.Piirtopaneeli;
import teos.logiikka.Musiikki;
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

    public void musiikki() {
        Musiikki musa = new Musiikki();

    }

    /**
     * lukee, tarkistaa ja delegoi piirtämisen
     *
     *
     */
    public void lueTarkistaPiirra() {
        String data = lue.haeTiedosto();
        if (data.startsWith("virhe")) {
            virhe = "tiedän: " + data;
            naytto.ilmoitaVirhe(virhe);
        }
        p.piirraTeksti(data);
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

    /**
     * valittaa liikkumis käskyn
     */
    public void liikuta(char i) {
        
    }

    public String getVirhe() {
        return virhe;
    }

    public void setJPanel(Piirtopaneeli p) {
        this.p = p;
    }

}
