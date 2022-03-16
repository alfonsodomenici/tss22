/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cellphone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class CellPhone {
    private final String gestore;
    private final String num;
    
    private static class Tariffa{
        private final String from;
        private final String to;
        private final double cost;

        public Tariffa(String from, String to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        
    }

    private static final List<Tariffa> tariffe= new ArrayList<>();
    
    public CellPhone(String gestore, String num) {
        this.gestore = gestore;
        this.num = num;
    }

    
    public static void setCost(String from, String to, double cost){
        tariffe.add(new Tariffa(from, to, cost));
    }
    
    public double getCost(CellPhone to, int durataMinuti){
        for (Tariffa tariffa : tariffe) {
            if(tariffa.from.equals(this.gestore) && tariffa.to.equals(to.getGestore())){
                return tariffa.cost * durataMinuti;
            }
        }
        throw new RuntimeException("Tariffa non trovata");
    }
    /*
    getter setter
    */
    public String getGestore() {
        return gestore;
    }

    public String getNum() {
        return num;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.num);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CellPhone other = (CellPhone) obj;
        return Objects.equals(this.num, other.num);
    }

    @Override
    public String toString() {
        return "CellPhone{" + "gestore=" + gestore + ", num=" + num + '}';
    }
    
    
    
}
