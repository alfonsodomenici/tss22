/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bank;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class ContoCorrenteConEstrattoConto extends ContoCorrente {

    private ArrayList<Integer> movimenti = new ArrayList<>();

    public ContoCorrenteConEstrattoConto(String intestatario) {
        super(intestatario);
    }

    public ArrayList<Integer> getMovimenti() {
        return new ArrayList(this.movimenti);
    }

    @Override
    public void deposito(int somma) {
        super.deposito(somma); 
        movimenti.add(somma);
    }

    @Override
    public void prelievo(int somma) {
        super.prelievo(somma);
        movimenti.add(-somma);
    }
    
    
    
}
