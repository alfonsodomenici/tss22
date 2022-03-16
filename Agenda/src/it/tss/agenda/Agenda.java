/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Agenda {

    private final List<Appuntamento> appuntamenti = new ArrayList<>();

    public Appuntamento aggiungi(LocalDate data,
            LocalTime inizio,
            LocalTime fine,
            String luogo,
            String persona) throws AgendaException {
        Objects.requireNonNull(data);
        inizio = Objects.requireNonNullElse(inizio, LocalTime.MIN);
        fine = Objects.requireNonNullElse(fine, LocalTime.MAX);
        
        if (data.isBefore(LocalDate.now())) {
            throw new AgendaException("data appuntamento non valida");
        }
        Appuntamento result = new Appuntamento(data, inizio, fine, luogo, persona);
        boolean isInvalid = appuntamenti.stream().anyMatch(v -> v.invalid(result));
        if (isInvalid) {
            throw new AgendaException(String.format("%s alle %s fino alle %s ad %s con %s",
                data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                inizio, fine, luogo, persona));
        }
        appuntamenti.add(result);
        return result;
    }

    public void cancella(Appuntamento a) {
        appuntamenti.remove(a);
    }

    public void cancella(LocalDate data, String luogo, String persona) {
        appuntamenti.removeAll(cerca(data, luogo, persona));
    }

    public List<Appuntamento> tutti() {
        return appuntamenti.stream().collect(Collectors.toList());
    }
    
    public List<Appuntamento> cerca(LocalDate data, String luogo, String persona) {
        Predicate<Appuntamento> byDate = v -> data == null || v.getData().equals(data);
        Predicate<Appuntamento> byLuogo = v -> luogo == null || luogo.isBlank()
                || v.getLuogo().trim().toLowerCase().equals(luogo.trim().toLowerCase());
        Predicate<Appuntamento> byPersona = v -> persona == null || persona.isBlank()
                || v.getPersona().trim().toLowerCase().equals(persona.trim().toLowerCase());

        return appuntamenti.stream()
                .filter(byDate.and(byLuogo).and(byPersona))
                .collect(Collectors.toList());
    }

    public void stampa() {
        Comparator<Appuntamento> comp = (a,b) -> a.getPersona().compareTo(b.getPersona());
        System.out.println("-------------- Agenda ---------------------");
        //appuntamenti.forEach(v -> System.out.println(v));
        //appuntamenti.forEach(System.out::println);ù
        appuntamenti.stream().sorted(comp).forEach(this::stampaAppuntamento);
    }

    public void stampaAppuntamento(Appuntamento a) {
        String frase = String.format("%s alle %s fino alle %s ad %s con %s",
                a.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                a.getInizio(), a.getFine(), a.getLuogo(), a.getPersona());
        System.out.println(frase);
    }
}
