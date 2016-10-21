/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import teos.logiikka.TiedostonLuku;
import teos.logiikka.VirheetJaSiivous;
import teos.ohjaaja.Ohjaus;

/**
 * Ajaa ohjelman.
 *
 * @author Sami
 */
public class Aja {

    /**
     * Ajaa ohjelman.
     *@param args args
     *
     */

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TiedostonLuku lue = new TiedostonLuku();
                VirheetJaSiivous vs = new VirheetJaSiivous();
                Naytto n = new Naytto();
                Ohjaus ohjaus = new Ohjaus(n, lue, vs);
                ohjaus.aloitus();
            }
        });

    }

}
