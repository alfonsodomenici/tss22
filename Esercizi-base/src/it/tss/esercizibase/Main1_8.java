/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.esercizibase;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Main1_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci numero");
        int x = sc.nextInt();
        int n = 1;
        int sommaDivisori = 0;
        while (n < x) {
            if (x % n == 0) {
                sommaDivisori += n;
            }
            n++;
        }
        if (sommaDivisori == x) {
            System.out.println(x + " perfetto");
        } else if (sommaDivisori > x) {
            System.out.println(x + " abbondante");
        } else {
            System.out.println(x + " difettivo");
        }
    }
}
