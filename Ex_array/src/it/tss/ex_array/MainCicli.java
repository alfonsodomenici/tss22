/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex_array;

import java.util.Arrays;

/**
 *
 * @author tss
 */
public class MainCicli {
    public static void main(String[] args) {
        int[] x = {1,4,6,9};
        
        //while
        int i = 0;
        while(i < x.length){
            System.out.println(x[i]);
            i++;
        }
        
        System.out.println("------------------------------------");
        
        //do while
        i=0;
        do{
            System.out.println(x[i]);
            i++;
        }while(i<x.length);
        
        
        System.out.println("------------------------------------");
        
        
        //for
        for (int j = 0; j < x.length; j++) {
            int n = x[j];
            System.out.println(n);
        }
        
        System.out.println("------------------------------------");
        
        //foreach
        for (int n : x) {
            System.out.println(n);
        }
        
        System.out.println("------------------------------------");
        
        Arrays.stream(x).forEach(v -> {
            System.out.println(v);
        });
    }
}
