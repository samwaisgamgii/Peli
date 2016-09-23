/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import javax.swing.JOptionPane;

/**
 *
 * @author Sami
 */
public class GrafiikanTuotto extends Naytto {

    public GrafiikanTuotto() {

    }

    public String piirraTeksti(String data) {
        return data;
    }

    public void ilmoitaVirhe(String virhe) {
        JOptionPane.showMessageDialog(ikkuna, virhe,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

}
