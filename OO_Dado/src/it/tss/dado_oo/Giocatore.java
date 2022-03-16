/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.dado_oo;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Giocatore {

    private int soldi;
    private final int maxSoldi;
    private final int minSoldi;
    private Dado dado;
    
    public Giocatore() {
        this(10, 15, 5,6);
    }

    public Giocatore(int soldi) {
        this(soldi, soldi + 2, soldi - 2, 6);
    }

    public Giocatore(int soldi, int maxSoldi, int minSoldi, int facceDado) {
        this.dado = new Dado(facceDado);
        this.soldi = soldi;
        this.maxSoldi = maxSoldi;
        this.minSoldi = minSoldi;
    }

    public void incrementaSoldi() {
        soldi++;
    }

    public void decrementaSoldi() {
        soldi--;
    }

    public int getSoldi() {
        return soldi;
    }

    public boolean isContinua() {
        return soldi > minSoldi && soldi < maxSoldi;
    }
    
    public void lancia(){
        this.dado.lancia();
    }
    
    public int getUltimoLancio(){
        return this.dado.getUltimoLancio();
    }
    
    public ArrayList<Integer> getStoria(){
        return dado.getStoria();
    }
}
