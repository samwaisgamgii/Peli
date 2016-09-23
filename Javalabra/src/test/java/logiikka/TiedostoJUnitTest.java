package logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import teos.logiikka.TiedostonLuku;
import teos.ohjaaja.Ohjaus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import teos.kayttoliittyma.GrafiikanTuotto;
import teos.kayttoliittyma.Naytto;
import teos.logiikka.VirheetJaSiivous;

/**
 *
 * @author Sami
 */
public class TiedostoJUnitTest {

    TiedostonLuku lue;
    GrafiikanTuotto draw;
    VirheetJaSiivous vs;
    Naytto n;
    Ohjaus ohjaus;

    @Before
    public void setUp() {
        this.lue = new TiedostonLuku();
        this.draw = new GrafiikanTuotto();
        this.vs = new VirheetJaSiivous();
        this.n = new Naytto();

    }

    @Test
    public void VaaraPolku() {
        this.ohjaus = new Ohjaus(n, lue, vs, draw);
        ohjaus.aloitus("/Users/Virhe/Sami/Documents/GitHub/Peli/Teos", ".txt");
        assertEquals("tiedän: virhe : polkua ei ole!", ohjaus.getVirhe());

    }

}
