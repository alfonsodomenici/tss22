/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.compito;

/**
 *
 * @author tss
 */
public interface Articolo {
    public String getNome();
    public double getPrezzo();
    
    @Override
    public  String toString();
}
