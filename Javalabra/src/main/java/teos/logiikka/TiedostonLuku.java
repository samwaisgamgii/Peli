/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.logiikka;

import java.io.File;
import java.util.Scanner;
import teos.ohjaaja.Ohjaus;

/**
 *
 * @author Sami
 */
public class TiedostonLuku {

    private String data = "";
    private Scanner lue = null;
    private Ohjaus ohjaus;
    private File[] tiedostolista;
    private String polku;

    public TiedostonLuku() {

    }

    /**
     * hakee kaikki tietyn tyyppiset tiedostot polusta lukee ne kaikki yhteen
     * String tiedostoon
     *
     * @return data tiedostosta
     */
    public String haeTiedosto() {
        polku = ohjaus.luoGuiIO();
        File kansio = new File(polku);
        if (!kansio.exists()) {
            return "virhe : polkua ei ole!";
        }
        try {
            tiedostolista = kansio.listFiles();
            data = lue(tiedostolista);
        } catch (Exception e) {
            return "virhe : tiedostoa ei voitu lukea" + e;
        }

        return data;
    }

    /**
     * käy tiedostonlistan läpi ja lukee tiedot String
     *
     * @param tiedostolista läpi käytävä file lista
     * @return data
     */
    public String lue(File[] tiedostolista) {

        data = "";
        for (int i = 0; i < tiedostolista.length; i++) {
            if (tiedostolista[i].getName().endsWith(".txt") || tiedostolista[i].getName().endsWith(".java")) {
                try {
                    lue = new Scanner(tiedostolista[i]);
                    while (lue.hasNextLine()) {
                        data = data + lue.nextLine() + "\n";

                    }
                } catch (Exception e) {
                    return "virhe : tiedostoa ei voitu lukea";
                }
            }
        }
        if (lue != null) {
            lue.close();
        }
        if (data.equals("")) {
            return "virhe: ei lyödy määriteltyjä tiedostotyyppejä";
        }
        return data;

    }

    public void setOhjaus(Ohjaus ohjaus) {
        this.ohjaus = ohjaus;
    }

    public Ohjaus getOhjaus() {
        return this.ohjaus;
    }

}
