/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.compito;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author tss
 */
public class ProvaMobile {
    
    public static  List<Mobile> scegli(Catalogo<Mobile> cat, double prezzo, int l, int alt, int prof){
        return cat.getArticoli()
                .stream()
                .filter(v-> v.getPrezzo()< prezzo)
                .collect(Collectors.toList());
                
    }
}
