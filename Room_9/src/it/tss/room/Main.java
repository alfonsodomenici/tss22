/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.room;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

/**
 *
 * @author tss
 */
public class Main {

    static int contaTentativiPrenotazione = 0;

    public static void main(String[] args) {
        Room r = new Room();
        prenota(r, "alfonso", LocalDate.of(2022, Month.MARCH, 15), LocalDate.of(2022, Month.MARCH, 30));
        prenota(r, "mario", LocalDate.of(2022, Month.MAY, 15), LocalDate.of(2022, Month.MAY, 30));
        prenota(r, "giovanna", LocalDate.of(2022, Month.FEBRUARY, 25), LocalDate.of(2022, Month.MARCH, 14));

        //1 
        prenota(r, "paola", LocalDate.of(2022, Month.MAY, 30), LocalDate.of(2022, Month.JUNE, 14));

        //2 
        prenota(r, "paolo", LocalDate.of(2022, Month.JANUARY, 30), LocalDate.of(2022, Month.FEBRUARY, 25));

        //3
        prenota(r, "marco", LocalDate.of(2022, Month.MAY, 10), LocalDate.of(2022, Month.MAY, 31));

        r.reservations().forEach(v -> System.out.println(v));
        
        System.out.println("numero tentativi: " + contaTentativiPrenotazione);
    }

    public static Optional<Room.Reservation> prenota(Room r, String nome, LocalDate inizio, LocalDate fine) {
        try {
            return Optional.of(r.reserve(nome, inizio, fine));
        } catch (ReservationException ex) {
            System.err.println("prenotazione non valida...");
            System.err.println(ex.getR());
            return Optional.empty();
        } finally {
            contaTentativiPrenotazione++;
        }

    }
}
