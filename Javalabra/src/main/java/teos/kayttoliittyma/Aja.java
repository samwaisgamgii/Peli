/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import java.awt.EventQueue;
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
                VirheetJaSiivous vs = new VirheetJaSiivous();
                Naytto n = new Naytto();
                Ohjaus ohjaus = new Ohjaus(n, lue, vs);
                ohjaus.aloitus();

       

    }

}
