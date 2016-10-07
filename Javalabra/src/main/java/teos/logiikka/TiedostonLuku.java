/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.logiikka;

import java.io.File;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author Sami
 */
public class TiedostonLuku {

    private String data = "";
    private Scanner lue = null;
    private File[] tiedostolista;
    private String polku, tyyppi = "";

    public TiedostonLuku() {

    }

    /**
     * luo guin polun määrittelemiseen
     *
     */
    private void polkuGui() {
        JButton avaa = new JButton();

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(null);
        fc.setDialogTitle("Kerro missä tiedostot ovat");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (fc.showOpenDialog(avaa) == JFileChooser.APPROVE_OPTION) {
            System.out.println("apua");
        }
        polku = fc.getSelectedFile().getAbsolutePath();
        tyyppi = ".txt";
    }

    /**
     * hakee kaikki tietyn tyyppiset tiedostot polusta lukee ne kaikki yhteen
     * String tiedostoon
     *
     */
    public String haeTiedosto() {
        polkuGui();
        File kansio = new File(polku);
        System.out.println(polku);
        if (!kansio.exists()) {
            return "virhe : polkua ei ole!";
        }
        tiedostolista = kansio.listFiles();
        data = lue(tiedostolista, tyyppi);

        return data;
    }

    /**
     * käy tiedostonlistan läpi ja lukee tiedot String
     *
     */
    public String lue(File[] tiedostolista, String tyyppi) {

        data = "";
        for (int i = 0; i < tiedostolista.length; i++) {
            if (tiedostolista[i].getName().endsWith(tyyppi)) {
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
        if (lue != null) {
            lue.close();
        }
        if (data.equals("")) {
            return "virhe: ei lyödy määriteltyjä tiedostotyyppejä";
        }
        return data;

    }

}
