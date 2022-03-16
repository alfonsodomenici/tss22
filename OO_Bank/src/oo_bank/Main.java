/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bank;

/**
 *
 * @author tss
 */
public class Main {
    public static void main(String[] args) {
        ContoCorrenteConEstrattoConto cc = new ContoCorrenteConEstrattoConto("alfonso");
        cc.deposito(100);
        cc.prelievo(35);
        System.out.println("intestatario: " + cc.getIntestatario() + " saldo: " + cc.getSaldo());
        System.out.println(cc.getMovimenti());
        
        ContoCorrente cc1 = new ContoCorrente("xx");
    }
}
