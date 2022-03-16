/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.oo_interfacce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tss
 */
public class Main2 {
    public static void main(String[] args) {
        List<Anagrafica> elenco = new ArrayList<>();
        elenco.add(new Anagrafica("mario","rossi"));
        elenco.add(new Anagrafica("marco", "bianchi"));
        
        System.out.println(elenco);
        
        Collections.sort(elenco);
        
        System.out.println(elenco);
        
        
    }
}
