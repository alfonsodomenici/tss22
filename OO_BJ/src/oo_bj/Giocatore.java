/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bj;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Giocatore extends AbstractGiocatore {

    private int soldi;
    private final int maxSoldi;
    private final int minSoldi;

    public Giocatore(String nome) {
        this(nome, 10, 15, 5);
    }

    public Giocatore(String nome, int soldi) {
        this(nome, soldi, soldi + 2, soldi - 2);
    }

    public Giocatore(String nome, int soldi, int maxSoldi, int minSoldi) {
        super(nome);
        this.soldi = soldi;
        this.maxSoldi = maxSoldi;
        this.minSoldi = minSoldi;
    }

    /*
    ------------------------------ metodi -------------------------------------
     */

    @Override
    protected boolean isContinua() {
        return valoreMano() <= 15;
    }
    
    
    public void incrementaSoldi() {
        soldi++;
    }

    public void decrementaSoldi() {
        soldi--;
    }

    public boolean isContinuaPartita() {
        return soldi > minSoldi && soldi < maxSoldi;
    }


    /*
    ---------------------- getter setter --------------------------------------
     */
    public int getSoldi() {
        return soldi;
    }


    /*
    --------------------- equals hashcode tostring ----------------------------
     */


}
