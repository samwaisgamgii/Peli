/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Sami
 */
public class Piirtopaneeli extends JPanel implements ActionListener {

    private JFrame j;
    private  int delay = 1;
    private String data;
    private Naytto n;
    private Timer time;
    private boolean matrix = true, peli = false;
    private ArrayList lista = new ArrayList();
    int m = 0;
    private int x,y, w, h, valmis = 0, monesX = 10, monesY = 20;
   
    private char dataC = ' ';

    public Piirtopaneeli() {

    }

    /**
     * Ajastaa
     *
     *
     */
    public Piirtopaneeli(JFrame jf) {
        j = jf;
        time = new Timer(delay, this);
        time.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirtele(g);
        

    }


    /**
     * hoitaa kahden moden piirtämisen
     *
     * @param g Käyttäjän antama syöte
     *
     *
     */
    public void piirtele(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        if (data != null && matrix == true) {
            g2d.setColor(Color.GREEN);
            for (int i = 0; i <= m; i = i + 3) {
                String d = (String) lista.get(i);
                int xs = (int) lista.get(i + 1);
                int ys = (int) lista.get(i + 2);
                g2d.drawString(d, xs, ys);
                if (xs == x && ys == y) {
                    System.exit(0);
                }
            }
            if (m < lista.size() - 3) {
                m++;
            } else {
                m = 0;
            }

        }
        if (peli == true) {
            delay = 400;
            time.setDelay(delay);
            g2d.setColor(Color.RED);
            g2d.fillRect(x, y, 10, 10);
            g2d.setColor(Color.GREEN);
            for (int i = 0; i < data.length()/2; i++) {
                if (monesX >= w - 30) {
                    monesX = 10;
                    monesY = monesY + 5;
                }
                if (monesY >= h - 20) {
                    monesY = 20;
                }               
                
                dataC = data.charAt(i);
                monesX = monesX + 3;
                g2d.drawString(String.valueOf(dataC), monesX, monesY);

            }
        }
    }

    public void peli() {
        matrix = false;
        peli = true;
    }

    /**
     * Liikuttaa neliötä joka seikkailele sokkelossa
     *
     * @param t Käyttäjän antama syöte
     *
     *
     */
    public void liiku(char t) {
        if (t == 't') {
            x = x - 10;
        }
        if (t == 'e') {
            x = x + 10;
        }
        if (t == 'y') {
            y = y - 10;
        }
        if (t == 'a') {
            y = y + 10;
        }

    }

    /**
     * laittaa datan arraylistaan
     *
     * @param data Käyttäjän antama syöte
     *
     *
     */
    public void piirraTeksti(String data) {
        this.data = data;
        w = j.getWidth();
        h = j.getHeight();
        double h2 = 1.3;
        x = w / 2;
        y = (h / 1)-20;
        for (int i = 0; i < data.length(); i++) {
            if (monesX >= w - 30) {
                monesX = 10;
                monesY = monesY + 20;
            }
            if (monesY >= h - 20) {
                monesY = 20;
            }

            dataC = data.charAt(i);
            monesX = monesX + 10;

            lista.add(String.valueOf(dataC));
            lista.add(monesX);
            lista.add(monesY);
        }

    }

    public void setNaytto(Naytto n) {
        this.n = n;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

}
