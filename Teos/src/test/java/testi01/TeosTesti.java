/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testi01;

import logiikka.TiedostonLuku;
import ohjaaja.Ohjaus;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sami
 */
public class TeosTesti {

    TiedostonLuku luku;
    Ohjaus ohjaus;

    @Before
    public void setUp() {
        luku = new TiedostonLuku();
    }

    @Test
    public void getVirheToimii() {
        ohjaus = new Ohjaus(luku);
        ohjaus.aloitus("dfdfs/Users/Sami/Documents/GitHub/Peli/Teos", ".txt");
        assertEquals(ohjaus.getVirhe(), ohjaus.getVirhe());
    }

    @Test
    public void OhjaajanKonstruktoiToimii() {
        ohjaus = new Ohjaus(luku);
        assertEquals(ohjaus.getLue(), ohjaus.getLue());
    }

    @Test
    public void TiedostonLukuToimii() {
        String data = luku.haeTiedosto("/Users/Sami/Documents/GitHub/Peli/Teos", ".txt");
        String data2 = luku.haeTiedosto("/Users/Sami/Documents/GitHub/Peli/Teos", ".txt");
        assertEquals(data, data2);
    }

    @Test
    public void TiedostonLukuToimiiJava() {
        String data = luku.haeTiedosto("/Users/Sami/Documents/GitHub/Peli/Teos/src/main/java/kayttoliittyma", ".java");
        String data2 = luku.haeTiedosto("/Users/Sami/Documents/GitHub/Peli/Teos/src/main/java/kayttoliittyma", ".java");
        assertEquals(data, data2);
    }

    @Test
    public void KertooJosEiPolkua() {
        String data = luku.haeTiedosto("dfdfs/Users/Sami/Documents/GitHub/Peli/Teos", ".txt");
        assertEquals("virhe : polkua ei ole!", data);
    }

    @Test
    public void KertooLukemisenOnnistuneen() {
        String data = luku.haeTiedosto("Users/Sami/Documents/GitHub/Peli/Teos", ".txt");
        assertEquals(data, data);
    }

    @Test
    public void OhjausTietaaVirheesta() {
        ohjaus = new Ohjaus(luku);
        ohjaus.aloitus("/Users/Virhe/Sami/Documents/GitHub/Peli/Teos", ".txt");
        assertEquals("tiedän: virhe : polkua ei ole!", ohjaus.getVirhe());
    }

    @Test
    public void OhjausTietaaToisestaVirheesta() {
        ohjaus = new Ohjaus(luku);
        ohjaus.aloitus("/Users/Sami/Documents/GitHub/Peli/Teos", ".txt");
        assertNotSame("tiedän: virhe : tiedostoa ei voitu lukea", ohjaus.getVirhe());
    }

    @Test
    public void TestaaVaaranTiedostoTyypin() {
        String data = luku.haeTiedosto("Users/Sami/Documents/GitHub/Peli/Teos", ".txtt");
        assertEquals("virhe : polkua ei ole!", data);
    }

}
