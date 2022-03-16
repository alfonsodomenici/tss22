/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author tss
 */
public class Main {
    public static void main(String[] args) {
        try {
            long count = Files.readAllLines(Paths.get("/home/tss/Documenti/pseudocodice.txt"))
                    .stream()
                    .filter(v -> !v.isBlank())
                    .filter(v -> v.toLowerCase().equals("start"))
                    .count();
                    System.out.println("numero algoritmi: " + count);
                    
                    IntStream.rangeClosed(1, 1000)
                            .forEach(Main::stampaNumero);
                    
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    static void stampaNumero(int x){
        System.out.println("numero:" + x);
    }
}
