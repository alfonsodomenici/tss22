/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.dado_oo;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {
        Giocatore g = new Giocatore(10, 15, 5, 6);
        Dado dadoB = new Dado(6);
        int conta = 1;
        do {
            g.lancia();
            dadoB.lancia();
            if (g.getUltimoLancio() > dadoB.getUltimoLancio()) {
                g.incrementaSoldi();
            } else {
                g.decrementaSoldi();
            }
            conta++;
        } while (g.isContinua());

        stampa(g.getStoria(), dadoB.getStoria(), g.getSoldi());
    }

    private static void stampa(ArrayList<Integer> g, ArrayList<Integer> b, int soldi) {
        for (int i = 0; i < g.size(); i++) {
            System.out.println(stampaMano(i + 1, g.get(i), b.get(i)));
        }
        stampaGiocatore(soldi);
    }

    private static String stampaMano(int conta, int lancioG, int lancioB) {
        return String.format("mano numero %s banco=%s giocatore=%s", conta, lancioB, lancioG);
    }

    private static void stampaGiocatore(int soldi) {
        System.out.println("soldi giocatore: " + soldi);
    }

}
