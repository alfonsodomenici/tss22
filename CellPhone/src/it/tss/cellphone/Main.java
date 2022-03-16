/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.cellphone;

/**
 *
 * @author tss
 */
public class Main {
    public static void main(String[] args) {
        CellPhone c1 = new CellPhone("TIM", "339345678");
        CellPhone c2 = new CellPhone("VODAFONE", "349112233");
        CellPhone c3 = new CellPhone("TRE", "336657321");
        
        CellPhone.setCost("TIM", "TIM", 0.5);
        CellPhone.setCost("TIM", "VODAFONE", 1.5);
        CellPhone.setCost("VODAFONE", "TIM", 0.8);
        
        System.out.println(c1.getCost(c2, 10));
        System.out.println(c2.getCost(c1, 10));
        
        //errori
        //System.out.println(c1.getCost(c3, 10));
        //  System.out.println(c3.getCost(c2, 10));
    }
}
