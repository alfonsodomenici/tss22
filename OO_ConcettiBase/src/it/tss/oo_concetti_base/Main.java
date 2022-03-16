/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.oo_concetti_base;

/**
 *
 * @author tss
 */
public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
        B b = new B();
        
        A aa = new B(); //SI
        
        if(a instanceof B){
            System.out.println("contiene un oggetto di tipo B");
        }else{
            System.out.println("non contiene un oggetto di tipo B");
        }
        
        aa.m2();
        
        //B bb = new A(); //NO... 
        aa = new C();
        
        aa.m2();
        
        
    }
    
}
