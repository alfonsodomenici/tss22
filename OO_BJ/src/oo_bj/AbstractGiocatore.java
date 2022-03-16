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
public abstract class AbstractGiocatore {

    protected String nome;
    protected final ArrayList<Carta> mano = new ArrayList<>();

    public AbstractGiocatore(String nome) {
        this.nome = nome;
    }

    /*
    ------------------------ metodi astratti -----------------------------------
     */
    
    protected abstract boolean isContinua();
    
    
    /*
    ------------------------- metodi -------------------------------------------
     */
    public void initMano() {
        mano.clear();
    }

    public void addCarta(Carta c) {
        mano.add(c);
    }

    /**
     * restituisce la somma dei valori delle carte in mano
     *
     * @return
     */
    public int valoreMano() {
        int result = 0;
        for (Carta carta : mano) {
            result += carta.getValore();
        }
        return result;
    }

    /**
     * indica se il giocatore è fuori dalla mano
     *
     * @return
     */
    public boolean isOut() {
        return valoreMano() > 21;
    }
    
    public boolean isContinuaMano(){
        return !isOut() && isContinua();
    }

    private String manoToString() {
        String result = "";
        for (Carta carta : mano) {
            result += carta.toString() + ",";
        }
        return result;
    }

    /*
    ----------------------- getter setter --------------------------------------
     */
    public String getNome() {
        return nome;
    }

    /*
    --------------------- equals hashcode tostring ----------------------------
     */
    @Override
    public String toString() {
        return this.nome + " mano: " + manoToString();
    }
}
