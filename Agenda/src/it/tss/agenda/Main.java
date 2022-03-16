/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        creaAppuntamento(agenda, LocalDate.now(), LocalTime.of(14, 30),
                LocalTime.of(15, 30), "ivrea", "paola");

        creaAppuntamento(agenda, LocalDate.now(), LocalTime.of(16, 00),
                LocalTime.of(18, 30), "rivarolo", "marco");

        creaAppuntamento(agenda, LocalDate.now(), LocalTime.of(18, 30),
                LocalTime.of(19, 30), "rivarolo", "giuseppe");

        creaAppuntamento(agenda, LocalDate.now().plusDays(1), LocalTime.of(16, 00),
                LocalTime.of(18, 30), "ivrea", "maria");

        creaAppuntamento(agenda, LocalDate.now().plusDays(10), LocalTime.of(16, 00),
                LocalTime.of(18, 30), "ivrea", "maria");


        agenda.stampa();
        
        Map<String, List<Appuntamento>> perPersona = agenda.tutti()
                .stream()
                .collect(Collectors.groupingBy(Appuntamento::getPersona));

        System.err.println(perPersona);
    }

    private static Appuntamento creaAppuntamento(Agenda a, LocalDate data, LocalTime inizio,
            LocalTime fine, String luogo, String persona) {
        try {
            return a.aggiungi(data, inizio, fine, luogo, persona);
        } catch (AgendaException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
