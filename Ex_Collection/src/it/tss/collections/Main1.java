/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.collections;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Main1 {
    public static void main(String[] args) {
        
        String x = "ciao";
        String y = "ciao";
        System.out.println(x==y);
        ArrayList<Integer> dinamico = new ArrayList<>();
        dinamico.add(10);
        dinamico.add(20);
        System.out.println(dinamico);
        System.out.println(dinamico.get(0));
    }
}
