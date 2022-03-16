/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.oo_dado_strut;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class MainDadiPunteggio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("inserisci punteggio:");
        int punteggio = sc.nextInt();
        int g1 = 0;
        int g2 = 0;
        while (g1 < punteggio && g2 < punteggio) {
            int d1 = rnd.nextInt(5) + 1;
            int d2 = rnd.nextInt(5) + 1;
            System.out.println(String.format("d1: %s , d2: %s", d1, d2));
            if (d1 > d2) {
                g1++;
                System.out.println("mano vinta da g1->" + g1);
            } else if (d2 > d1) {
                g2++;
                System.out.println("mano vinta da g2->" + g2);
            }else{
                System.out.println("mano patta");
            }
        }
        if (g1 == punteggio) {
            System.out.println("partita vinta da g1");
        } else {
            System.out.println("partita vinta da g2");
        }
    }

}
