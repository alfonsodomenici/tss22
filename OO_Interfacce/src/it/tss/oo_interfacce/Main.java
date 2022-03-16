/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.oo_interfacce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tss
 */
public class Main {
    public static void main(String[] args) {

        Integer[] arr = {10,2,4,4,6,7,6};
        
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        
        System.out.println(list);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println("elemento: " + list.get(i) ); 
            if(list.get(i)==4){
                list.remove(i);
            }
        }
        
        System.out.println("----------------------------------------");
        
        for (Integer n : list) {
            System.out.println("elemento: " + n );
            if(n==4){
                list.remove(n);
            }
        }
        
        System.out.println(list);
        /*
        Set<Integer> set = new HashSet<>(list);
        
        System.out.println(set);
        
        List<Integer> numeri = new ArrayList<>();
        */
        
    }
    
}
