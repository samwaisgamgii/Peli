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

/**
 * Pallon esittämiseen tarvittava luokka.
 *
 * @author Sami
 */
public class Pallo {

    private boolean ylos = false, alas = false, eteen = false, taakse = false;
    private Graphics2D g2d;
    private ArrayList<Shape> p;
    private Point2D p2;
    private int size = 4;
    private int x, y, radius, w, h;

    /**
     * konstruktori.
     */
    public Pallo() {

    }

    /**
     * paramitrinen konstruktori.
     * @param x x
     * @param y y
     * @param radius säde
     */
    public Pallo(int x, int y, int radius) {

        this.x = x;
        this.y = y;
        this.radius = radius;
        p = new ArrayList<>();
        p.add(new Ellipse2D.Double(x, y, radius, radius));

    }

    /**
     * asettaa näytön leveyden.
     *
     * @param w leveys
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * asettaa näytön korkeuden.
     *
     * @param h korkeus
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * liikuttaa ympyrää ja piirtää sen.
     *
     * @param g grafiikka
     *
     */
    public void drawP(Graphics g) {
        liikuta();
        piirraYmpyra(g, x, y, radius);

    }

    /**
     * käy listan läpi ja piirtää ne.
     *
     * @param g grafiikka
     * @param x x sijainti
     * @param y y sijainti
     * @param radius ympyrän säde
     */
    public void piirraYmpyra(Graphics g, int x, int y, int radius) {
        g2d = (Graphics2D) g;

        for (int i = 0; i < p.size(); i++) {
            g2d.draw(p.get(i));
        }

    }

    /**
     * testaa onko piste ympyrän sisällä.
     *
     * @param xK testatavan pisteen x
     * @param yK testattavan pisteen y
     * @return true, false
     */
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

    /**
     * liikuttaa ympyrää.
     *
     *
     */
    public void liikuta() {
        if (alas) {
            if (y < 0 - radius / 3) {
                y = h;
            }
            y = y - 3;

        }
        if (ylos) {
            if (y > h + radius / 5) {
                y = 0;

            }
            y = y + 3;

        }
        if (eteen) {
            if (x > w + radius / 5) {
                x = 0;
            }
            x = x + 3;

        }
        if (taakse) {
            if (x < 0 - radius / 3) {
                x = w;
            }
            x = x - 3;

        }
        p.add(new Ellipse2D.Double(x, y, radius, radius));
        if (p.size() > size) {
            p.remove(0);
        }
    }

    /**
     * tarkastaa liikuttamis syötteen ja sijoittaa oikeat boolean arvot.
     *
     * @param l liikkumis ID
     */
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

    /**
     * kasvattaa ympyrää.
     *
     */
    public void kasvata() {
        if (radius < 80) {
            radius++;
        } else {
            radius = (int) ((int) 30 + (Math.random() * 50));
        }
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public ArrayList getP() {
        return this.p;
    }

    public int getR() {
        return this.radius;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
