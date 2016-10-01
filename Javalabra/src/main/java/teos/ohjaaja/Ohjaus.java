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

    public void aloitus(String polku, String tyyppi) {
        naytto.setOhjaus(this);
        naytto.luoIkkuna(Color.BLACK);
        String data = lue.haeTiedosto(polku, tyyppi);
        if (data.contains("virhe")) {
            virhe = "tiedän: " + data;
            naytto.ilmoitaVirhe(virhe);
        }
        p.piirraTeksti(data);

    }

    public void escPainettu() {
        vs.suljeOhjelma();
    }

    public String getVirhe() {
        return virhe;
    }

    public void setJPanel(Piirtopaneeli p) {
        this.p = p;
    }

}
