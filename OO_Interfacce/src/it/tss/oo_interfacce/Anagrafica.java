/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.oo_interfacce;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Anagrafica implements Comparable<Anagrafica> {
    private final String nome;
    private final String cognome;

    public Anagrafica(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    
    public String getNome() {
        return nome;
    }


    public String getCognome() {
        return cognome;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.cognome);
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
        final Anagrafica other = (Anagrafica) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cognome, other.cognome);
    }

    @Override
    public String toString() {
        return "Anagrafica{" + "nome=" + nome + ", cognome=" + cognome + '}';
    }

    @Override
    public int compareTo(Anagrafica o) {
        return this.getCognome().compareTo(o.getCognome());
    }
    
}
