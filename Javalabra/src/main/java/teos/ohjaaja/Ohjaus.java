/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.ohjaaja;

import teos.logiikka.TiedostonLuku;

/**
 *
 * @author Sami
 */
public class Ohjaus {

    private TiedostonLuku lue;
    private String virhe;

    public Ohjaus(TiedostonLuku lue) {
        this.lue = lue;
    }

    public void aloitus(String polku, String tyyppi) {
        String data = lue.haeTiedosto(polku, tyyppi);
        System.out.println(data);
        if (data.contains("virhe")) {
            virhe = "tiedän: " + data;
            // viesti käyttöliittymälle
        }
    }

    public TiedostonLuku getLue() {
        return lue;
    }

    public void setLue(TiedostonLuku lue) {
        this.lue = lue;
    }

    public String getVirhe() {
        return virhe;
    }

    public void setVirhe(String virhe) {
        this.virhe = virhe;
    }

}
