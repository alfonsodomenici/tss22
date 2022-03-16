package it.tss.esercizibase;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tss
 */
public class Main1_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il primo numero");
        int x = sc.nextInt();

        System.out.println("Inserisci il secondo numero");
        int y = sc.nextInt();

        if (x > y) {

            int z = x;

            x = y;

            y = z;
        }

        int numero = x;

        int risultato = 0;

        while (numero <= y) {

            risultato = risultato + numero;

            numero = numero + 1;

        }

        System.out.println("risultato: " + risultato);
    }
}
