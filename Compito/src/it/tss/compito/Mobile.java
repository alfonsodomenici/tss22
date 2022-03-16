/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.compito;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Mobile implements Articolo{

    private final String nome;
    private final double prezzo;
    private int larghezza, altezza, profondita;

    public Mobile(String nome, double prezzo, int larghezza, int altezza, int profondita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.profondita = profondita;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getProfondita() {
        return profondita;
    }
    

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public double getPrezzo() {
        return this.prezzo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.prezzo) ^ (Double.doubleToLongBits(this.prezzo) >>> 32));
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
        final Mobile other = (Mobile) obj;
        if (Double.doubleToLongBits(this.prezzo) != Double.doubleToLongBits(other.prezzo)) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public String toString() {
        return "Mobile{" + "nome=" + nome + ", prezzo=" + prezzo + '}';
    }
    
    
}
