/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.logiikka;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sami
 */
public class PalloTest {

    Pallo pallo;

    public PalloTest() {
    }

    @Before
    public void setUp() {
        pallo = new Pallo(5, 5, 10);
        pallo.setH(2000);
        pallo.setW(2000);
    }

    @Test
    public void liikutaAlas() {
        pallo.setY(5);
        pallo.liikutaS('y');
        pallo.liikuta();
        assertEquals(2, pallo.getY());

    }

    @Test
    public void kasvataRadius() {
        pallo.kasvata();
        assertEquals(11, pallo.getR());
    }

    @Test
    public void radiusEiKasvaYli() {
        Pallo pallo2 = new Pallo(5, 5, 79);
        pallo2.setH(2000);
        pallo2.setW(2000);
        pallo.kasvata();
        int radius = pallo.getR();
        if (radius > 81) {
            fail();
        }

    }

    @Test
    public void onkoSisallaToimii() {
        Pallo pallo3 = new Pallo(5, 5, 40);
        pallo3.setH(2000);
        pallo3.setW(2000);
        pallo3.liikuta();
        assertFalse(pallo3.onkoSisalla(7, 7));
    }

    @Test
    public void liikutaYlos() {
        pallo.setY(5);
        pallo.liikutaS('a');
        pallo.liikuta();
        assertEquals(8, pallo.getY());

    }

    @Test
    public void liikutaVasemmalle() {
        pallo.setX(5);
        pallo.liikutaS('t');
        pallo.liikuta();
        assertEquals(2, pallo.getX());

    }

    @Test
    public void liikutaOikealle() {
        pallo.setX(5);
        pallo.liikutaS('e');
        pallo.liikuta();
        assertEquals(8, pallo.getX());

    }

    @Test
    public void lisaaPalloLiikkumisenJalkeen() {
        Pallo pallo1 = new Pallo(5, 5, 10);
        pallo1.setH(2000);
        pallo1.setW(2000);
        pallo1.liikutaS('e');
        pallo1.liikuta();
        ArrayList lista = pallo.getP();
        assertEquals(1, lista.size());

    }

}
