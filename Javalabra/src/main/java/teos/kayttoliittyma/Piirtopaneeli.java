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
    private final int DELAY = 3;
    private String data;
    private Naytto n;
    private Timer time;
    private ArrayList lista = new ArrayList();
    int m = 0;
    private int w, h, valmis = 0, monesX = 10, y = 20;
    private char dataC = ' ';

    public Piirtopaneeli() {

    }

    public Piirtopaneeli(JFrame jf) {
        j = jf;
        time = new Timer(DELAY, this);
        time.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirtele(g);

    }

    public void piirtele(Graphics g) {

        if (data != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);

            for (int i = 0; i <= m; i = i + 3) {
                String d = (String) lista.get(i);
                int x = (int) lista.get(i + 1);
                int ys = (int) lista.get(i + 2);
                g2d.drawString(d, x, ys);
            }
            if (m < lista.size() - 3) {
                m++;
            } else {
                m = 0;
            }

        }

    }

    public void piirraTeksti(String data) {
        this.data = data;
        w = j.getWidth();
        h = j.getHeight();
        for (int i = 0; i < data.length(); i++) {
            if (monesX >= w - 30) {
                monesX = 10;
                y = y + 20;
            }
            if (y >= h - 20) {
                y = 20;
            }

            dataC = data.charAt(i);
            monesX = monesX + 10;

            lista.add(String.valueOf(dataC));
            lista.add(monesX);
            lista.add(y);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

}
