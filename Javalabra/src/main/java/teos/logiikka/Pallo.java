/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teos.logiikka;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sami
 */
public class Pallo {

    private boolean ylos = false, alas = false, eteen = false, taakse = false;
    private Graphics2D g2d;
    private ArrayList<Shape> p;
    private Point2D p2;
    private int size = 4;
    private int x, y, radius, W, H;

    public Pallo() {

    }

    public Pallo(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        p = new ArrayList<>();
        p.add(new Ellipse2D.Double(x, y, radius, radius));
        
    }

    public void setW(int W) {
        this.W = W;
    }

    public void setH(int H) {
        this.H = H;
    }

    public void drawP(Graphics g) {
        liikuta();
        piirraYmpyra(g, x, y, radius);

    }

    public void piirraYmpyra(Graphics g, int x, int y, int radius) {
        g2d = (Graphics2D) g;
        
        
      
        for (int i = 0; i < p.size(); i++) {
            g2d.draw(p.get(i));
        }

    }

    public boolean onkoSisalla(int xK, int yK) {
        p2 = new Point2D.Double(xK, yK);

        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).contains(p2)) {
                size++;
                kasvata();
                return true;
            }
        }
        // ((xK - x) ^ 2 + (yK - y) ^ 2) == (radius ^ 2)
        return false;
    }

    public void liikuta() {
        if (alas) {
            if (y < 0 - radius / 3) {
                y = H;
            }
            y = y - 3;

        }
        if (ylos) {
            if (y > H + radius / 5) {
                y = 0;

            }
            y = y + 3;

        }
        if (eteen) {
            if (x > W + radius / 5) {
                x = 0;
            }
            x = x + 3;

        }
        if (taakse) {
            if (x < 0 - radius / 3) {
                x = W;
            }
            x = x - 3;

        }
        p.add(new Ellipse2D.Double(x, y, radius, radius));
        if(p.size() > size){
            p.remove(0);
        }
    }

    public void liikutaS(char l) {
        if (l == 'y') {
            ylos = false;
            eteen = false;
            taakse = false;
            alas = true;
        }
        if (l == 'a') {
            alas = false;
            eteen = false;
            taakse = false;
            ylos = true;

        }
        if (l == 'e') {
            ylos = false;
            alas = false;
            taakse = false;
            eteen = true;

        }
        if (l == 't') {
            ylos = false;
            eteen = false;
            alas = false;
            taakse = true;

        }

    }

    public void kasvata() {
        if (radius < 80) {
            radius++;
        }
        else{
            radius = (int) ((int) 30+ (Math.random() * 50));
        }
        /*else{
            p.add(new Ellipse2D.Double(x-50, y-50, radius, radius));
        }*/

        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
