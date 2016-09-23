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
 *
 * @author Sami
 */
public class Aja {

    public static void main(String[] args) {
        TiedostonLuku lue = new TiedostonLuku();
        GrafiikanTuotto draw = new GrafiikanTuotto();
        VirheetJaSiivous vs = new VirheetJaSiivous();
        Naytto n = new Naytto();
        Ohjaus ohjaus = new Ohjaus(n, lue, vs, draw);
        ohjaus.aloitus("C:\\Users\\Sami\\Documents\\GitHub\\Peli\\Javalabra\\src\\main\\java\\teos\\kayttoliittyma", ".java");

    }

}
