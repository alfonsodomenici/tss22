/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex_array;

/**
 *
 * @author tss
 */
public class MainContieneSequenza {

    public static void main(String[] args) {
        boolean ris ;
        int tentativi=0;
        do {
            tentativi++;
            System.out.println("-------------- TENTATIVO " + tentativi + " ----------------");
            int[] input = ArraysTools.generaArrayCasuale(100, 10);
            int[] input1 = ArraysTools.generaArrayCasuale(4, 10);
            ArraysTools.stampa(input);
            ArraysTools.stampa(input1);
            ris = ArraysTools.contieneSequenza(input, input1);
            System.out.println("Contiene Sequenza: " + ris);
            System.out.println("----------------------------------------------------");
        }while(!ris);
    }
}
