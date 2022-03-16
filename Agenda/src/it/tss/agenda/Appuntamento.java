/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class Appuntamento {

    private final LocalDate data;
    private final LocalTime inizio;
    private final LocalTime fine;
    private final String luogo;
    private final String persona;

    public Appuntamento(LocalDate data, LocalTime inizio, LocalTime fine, String luogo, String persona) {
        this.data = data;
        this.inizio = inizio;
        this.fine = fine;
        this.luogo = luogo;
        this.persona = persona;
    }

    public boolean intersect(Appuntamento nuovo) {
        if (!this.data.equals(nuovo.data)) {
            return false;
        }
        if (this.isAllDay() || nuovo.isAllDay()) {
            return true;
        }
        if (this.inizio.isBefore(nuovo.inizio)
                && this.fine.isAfter(nuovo.inizio)) {
            return true;
        }
        return this.inizio.isBefore(nuovo.fine)
                && this.fine.isAfter(nuovo.fine);

    }

    public boolean overlap(Appuntamento nuovo) {
        return this.data.equals(nuovo.data) && (nuovo.inizio.isBefore(this.inizio) || nuovo.inizio.equals(this.inizio))
                && (nuovo.fine.isAfter(this.fine) || nuovo.fine.equals(this.fine));
    }

    public boolean invalid(Appuntamento a) {
        return  intersect(a) || overlap(a);
    }

    public boolean isAllDay() {
        return inizio == LocalTime.MIN && fine == LocalTime.MAX;
    }

    /*
    get e set
     */
    public LocalDate getData() {
        return data;
    }

    public LocalTime getInizio() {
        return inizio;
    }

    public LocalTime getFine() {
        return fine;
    }

    public String getLuogo() {
        return luogo;
    }

    public String getPersona() {
        return persona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.inizio);
        hash = 97 * hash + Objects.hashCode(this.fine);
        hash = 97 * hash + Objects.hashCode(this.luogo);
        hash = 97 * hash + Objects.hashCode(this.persona);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appuntamento other = (Appuntamento) obj;
        if (!Objects.equals(this.luogo, other.luogo)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.inizio, other.inizio)) {
            return false;
        }
        return Objects.equals(this.fine, other.fine);
    }

    @Override
    public String toString() {
        return "Appuntamento{" + "data=" + data + ", inizio=" + inizio + ", fine=" + fine + ", luogo=" + luogo + ", persona=" + persona + '}';
    }

}
