/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex_array;

import java.util.Random;

/**
 *
 * @author tss
 */
public class MainRicerca {

    public static void main(String[] args) {
        
        int[] input = ArraysTools.generaArrayCasuale(10, 10);
        int[] input1 = ArraysTools.generaArrayCasuale(2, 10);
        ArraysTools.stampa(input);
        ArraysTools.stampa(input1);
        System.out.println("ricerca 5: " + ArraysTools.ricerca(input, 5));
        System.out.println("MAX: " + ArraysTools.max(input));
        System.out.println("MIN: " + ArraysTools.min(input));
        System.out.println("SOMMA: " + ArraysTools.somma(input));
        System.out.println("MEDIA: " + ArraysTools.media(input));
        System.out.println("COPIA:");
        ArraysTools.stampa(ArraysTools.copia(input));
        System.out.println("UNISCI:");
        ArraysTools.stampa(ArraysTools.unisci(input,input1));
        System.out.println("INTERSEZIONE:");
        ArraysTools.stampa(ArraysTools.intersezione(input,input1));
        System.out.println("CONTIENE VALORI: " + 
                ArraysTools.contieneValori(input,input1));
        System.out.println("CONTIENE SEQUENZA: " + 
                ArraysTools.contieneValori(input,input1));
        System.out.println("ORDINA:");
        ArraysTools.ordinaBubble(input);
        ArraysTools.stampa(input);
    }

    /**
     *
     * @param ncelle numero di celle dell'array
     * @param max massimo intero contenuto nell'array
     * @return
     */
    

}
