/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cellphone;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author tss
 */
public class CellPhone {

    private static final Set<Tariffa> tariffe = new HashSet<>();

    private final String gestore;
    private final String num;

    public CellPhone(String gestore, String num) {
        this.gestore = gestore;
        this.num = num;
    }

    public static void setCost(String from, String to, double cost) {
        tariffe.add(new Tariffa(from, to, cost));
    }

    public double getCost(CellPhone dest, int durataMinuti) {
        
        Tariffa tariffa = find(this.gestore, dest.getGestore())
                .orElseThrow(() -> new RuntimeException("Tariffa inesistente.Impossibile calcolare il costo"));
        System.out.println(tariffa);
        return tariffa.getCost() * durataMinuti;
    }

    private Optional<Tariffa> find(String from, String to) {
        for (Tariffa tariffa : tariffe) {
            if (tariffa.getFrom().equals(from) && tariffa.getTo().equals(to)) {
                return Optional.of(tariffa);
            }
        }
        return Optional.empty();
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
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.num);
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
