/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bj;

/**
 *
 * @author tss
 */
public class Banco extends AbstractGiocatore {

    public Banco() {
        super("Banco");
    }

    @Override
    protected boolean isContinua() {
        return valoreMano() < 17;
    }

    @Override
    public void addCarta(Carta c) {
        super.addCarta(c);
        if(mano.size()>2){
            mano.get(1).setCoperta(false);
        }
    }
    
}
