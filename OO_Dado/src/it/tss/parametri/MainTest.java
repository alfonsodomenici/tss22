/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.parametri;

import java.util.Arrays;

/**
 *
 * @author tss
 */
public class MainTest {
    public static void main(String[] args) {
        int x = 10;
        m1(x);
        System.out.println("x=" + x);
        
        int[] numeri = {10,20};
        m2(numeri);
        System.out.println(Arrays.toString(numeri));
    }
    
    public static void m1(int numero){
        numero = numero + 10;
    }
    
    public static void m2(int[] num){
        num[1] = num[1] + 10;
    }
}
