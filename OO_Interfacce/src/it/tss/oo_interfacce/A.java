/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.oo_interfacce;

/**
 *
 * @author tss
 */
public interface A {
    
    public default void m1(){
        System.out.println("m1");
    }
    
    public default void m2(){
        System.out.println("m2");
    }
}
