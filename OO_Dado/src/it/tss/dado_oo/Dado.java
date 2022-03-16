/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.dado_oo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author tss
 */
public class Dado {

    private final int numeroFacce;
    private int ultimoLancio;
    private final ArrayList<Integer> storia = new ArrayList<>();
    
    public Dado(int nFacce) {
        this.numeroFacce = nFacce;
    }

    public void lancia() {
        Random rnd = new Random();
        ultimoLancio = rnd.nextInt(numeroFacce) + 1;
        storia.add(ultimoLancio);
    }

    public int getNumeroFacce() {
        return numeroFacce;
    }

    public int getUltimoLancio() {
        return ultimoLancio;
    }

    public ArrayList<Integer> getStoria() {
        return new ArrayList<>(storia);
    }
    
}
