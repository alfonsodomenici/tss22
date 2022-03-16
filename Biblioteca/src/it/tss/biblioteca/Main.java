/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.biblioteca;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tss
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Book a = new Book("a");
        Book b = new Book("b");
        Book c = new Book("c");
        Book d = new Book("a");
        Book e = new Book("e");
        
        Library biblio = new Library();
        System.out.println(biblio.addBook(a));
        System.out.println(biblio.addBook(b));
        System.out.println(biblio.addBook(c));
        System.out.println(biblio.addBook(d));
        
        biblio.loanBook(c);
        TimeUnit.MINUTES.sleep(1);
        biblio.loanBook(a);
        biblio.printLoan();
        biblio.returnBook(c);
        biblio.printLoan();
        
        //errori
        //  biblio.returnBook(e);
    }
}
