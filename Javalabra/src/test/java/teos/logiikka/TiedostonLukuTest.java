/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.logiikka;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import teos.kayttoliittyma.Naytto;
import teos.ohjaaja.Ohjaus;

/**
 *
 * @author Sami
 */
public class TiedostonLukuTest {

    private TiedostonLuku tl;

    public TiedostonLukuTest() {
    }

    @Before
    public void setUp() {
        tl = new TiedostonLuku();
    }

    @Test
    public void kertooJosEiLoydyTiedostoTyyppeja() {
        File kansio = new File("C:\\Users\\Sami\\Documents\\GitHub");
        File[] tiedostolista = kansio.listFiles();
        assertEquals("virhe: ei lyödy määriteltyjä tiedostotyyppejä", tl.lue(tiedostolista));

    }

    @Test
    public void lukeminenOnnistuu() {
        File kansio = new File("C:\\Users\\Sami\\Documents\\GitHub\\Peli");
        File[] tiedostolista = kansio.listFiles();
        assertNotEquals("virhe : tiedostoa ei voitu lukea", tl.lue(tiedostolista));
    }
    @Test
    public void haeTiedostoToimii(){
        TiedostonLuku lue = new TiedostonLuku();
        VirheetJaSiivous vs = new VirheetJaSiivous();
        Naytto n = new Naytto();
        Ohjaus ohjaus = new Ohjaus(n, lue, vs);
        tl.setOhjaus(ohjaus);
        assertNotNull(tl.haeTiedosto());
        
    }

    @Test
    public void ohjausAsentaminenToimii() {
        Ohjaus ohjaus = new Ohjaus();
        tl.setOhjaus(ohjaus);
        ohjaus = tl.getOhjaus();
        assertEquals(tl.getOhjaus(), ohjaus);
    }
}
