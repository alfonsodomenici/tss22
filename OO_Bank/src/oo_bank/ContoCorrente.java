/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bank;

/**
 *
 * @author tss
 */
public class ContoCorrente {

    private String intestatario;
    private int saldo;

    public ContoCorrente(String intestatario) {
        if (intestatario == null || intestatario.isBlank()) {
            throw new IllegalArgumentException("intestatario vuoto");
        }
        this.intestatario = intestatario;
    }

    public void deposito(int somma) {
        if (somma <= 0) {
            throw new IllegalArgumentException("somma uguale o minore di 0");
        }
        this.saldo += somma;
    }

    public  void prelievo(int somma) {
        if (somma <= 0) {
            throw new IllegalArgumentException("somma uguale o minore di 0");
        }
        if (somma > this.saldo) {
            throw new IllegalArgumentException("somma non disponibile");
        }
        this.saldo -= somma;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public int getSaldo() {
        return saldo;
    }

}
