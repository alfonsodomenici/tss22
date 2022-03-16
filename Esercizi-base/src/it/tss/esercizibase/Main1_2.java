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
public class Main1_2 {

    public static void main(String[] args) {
        Scanner lett = new Scanner(System.in);

        System.out.println("dammi primo numero");
        int x = lett.nextInt();

        System.out.println("dammi secondo numero");
        int y = lett.nextInt();
        
        int conta = 1;
        
        int risultato = 0;
        
        while(conta <= y){
            risultato = risultato + x;
            conta = conta + 1;
        }
        
        System.out.println("risultato: " + risultato);
    }
}
