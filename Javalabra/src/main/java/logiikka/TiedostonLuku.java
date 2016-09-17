/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class TiedostonLuku {

    public TiedostonLuku() {

    }

    // hakee kaikki tietyn tyyppiset tiedostot polusta
    // lukee ne kaikki yhteen String tiedostoon
    public String haeTiedosto(String polku, String tyyppi) {
        String data = "";
        Scanner lue = null;
        File kansio = new File(polku);
        if (!kansio.exists()) {
            return "virhe : polkua ei ole!";
        }
        File[] tiedostolista = kansio.listFiles();
        for (int i = 0; i < tiedostolista.length; i++) {
            File file = tiedostolista[i];
            try {
                lue = new Scanner(tiedostolista[i]);
                while (lue.hasNextLine()) {
                    data = data + lue.nextLine() + "\n";

                }
            } catch (FileNotFoundException e) {
                return "virhe : tiedostoa ei voitu lukea";
            }

        }
        lue.close();
        return data;
    }

}
