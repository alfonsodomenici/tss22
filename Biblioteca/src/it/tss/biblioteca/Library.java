/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.biblioteca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author tss
 */
public class Library {

    private final List<Book> libri;
    
    public Library() {
        libri = new ArrayList<>();
    }

    /**
     * aggiunge libro a libri, Se esiste già restituisce false, altrimenti true
     *
     * @param b
     * @return
     */
    public boolean addBook(Book b) {
        
        if (libri.contains(b)) {
            return false;
        } else {
            libri.add(b);
            return true;
        }

    }

    /**
     * mette un libro in prestito e torna true. Se è gia in prestito torna
     * false. Se non c'è in libri da errore
     *
     * @param b
     * @return
     */
    public boolean loanBook(Book b) {
        if (!libri.contains(b)) {
            throw new IllegalArgumentException("Il libro non esiste in biblio");
        }
        int indice = libri.indexOf(b);
        Book daPrestare = libri.get(indice);
        if (daPrestare.isLoan()) {
            return false;
        } else {
            daPrestare.setLoan(true);
            daPrestare.setData(LocalDateTime.now());
            return true;
        }
    }

    /**
     * mette un libro disponibile. se non è stato prestato o non esiste da
     * errore
     *
     * @param b
     */
    public void returnBook(Book b) {
        if (!libri.contains(b)) {
            throw new IllegalArgumentException("Il libro non esiste in biblio");
        }
        
        int indice = libri.indexOf(b);
        Book daRestituire = libri.get(indice);
        
        if (!daRestituire.isLoan()) {
            throw new IllegalArgumentException("Il libro restituito non era prestato");
        }
        
        daRestituire.setLoan(false);
        daRestituire.setData(null);
        
    }

    /**
     * stampa libri in prestito ordine temporale
     */
    public void printLoan() {
        Comparator<Book> compDate = (b1,b2) -> b1.getData().compareTo(b2.getData());
        List<Book> result = new ArrayList<>();
        for (Book book : libri) {
            if(book.isLoan()){
                result.add(book);
            }
        }
        result.sort(compDate);
        System.out.println(result);
    }


}
