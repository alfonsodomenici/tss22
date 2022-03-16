/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex_array;

/**
 *
 * @author tss
 */
public class Main2 {
    public static void main(String[] args) {
        int[] x = {10,20,20,40,50};
        
        int[] y = x;
        
        y[0]= -1;
        
        System.out.println("x[0]: " + x[0]);
    }
}
