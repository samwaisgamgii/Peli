/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.logiikka;

import java.io.File;
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
        System.out.println(polku);
        if (!kansio.exists()) {
            return "virhe : polkua ei ole!";
        }
        File[] tiedostolista = kansio.listFiles();
        for (int i = 0; i < tiedostolista.length; i++) {
            if (tiedostolista[i].exists() && tiedostolista[i].getName().endsWith(tyyppi)) {
                try {
                    lue = new Scanner(tiedostolista[i]);
                    while (lue.hasNextLine()) {
                        data = data + lue.nextLine() + "\n";
                        
                    }
                } catch (Exception e) {
                    return "virhe : tiedostoa ei voitu lukea" + e;
                }
                
            } 
        }
        lue.close();
        return data;
    }
    
}
