/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.compito;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 * @param <T>
 */
public class Catalogo<T extends Articolo> implements Iterable<T> {
    
    private final List<T> articoli = new ArrayList<>();
    
    public void aggiungiArticolo(T art){
        articoli.add(art);
    }
    
    public List<T> getArticoliSottoPrezzo(double prezzo){
        return articoli
                .stream()
                .filter(v -> v.getPrezzo()<= prezzo)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        for (T t : articoli) {
            risultato.append("\n").append(t.toString());
        }
        return risultato.toString();
    }
    
    public String convertiInString(){
        return articoli
                .stream()
                .map(Articolo::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<T> getArticoli() {
        return new ArrayList<>(articoli);
    }

    
    
    @Override
    public Iterator<T> iterator() {
        return articoli.iterator();
    }

    
    
}
