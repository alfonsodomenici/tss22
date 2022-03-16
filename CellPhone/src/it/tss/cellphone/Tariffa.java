/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cellphone;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Tariffa {
    private final String from;
    private final String to;
    private final double cost;

    public Tariffa(String from, String to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.from);
        hash = 89 * hash + Objects.hashCode(this.to);
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
        final Tariffa other = (Tariffa) obj;
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        return Objects.equals(this.to, other.to);
    }

    @Override
    public String toString() {
        return "Tariffa{" + "from=" + from + ", to=" + to + ", cost=" + cost + '}';
    }
    
    
    
    
}
