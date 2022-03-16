/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bj;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

/**
 *
 * @author tss
 */
public class Mazzo {

    public static final int NUMERO_CARTE = 52;

    private final ArrayList<Carta> carte;

    public Mazzo() {
        carte = new ArrayList<>(NUMERO_CARTE);
        crea();
    }

    /*
    -------------------------- metodi -----------------------------------------
    */
    
    /**
     * crea un nuovo mazzo di 52 carte francesi
     */
    public void crea() {
        carte.clear();
        EnumSet<Carta.Seme> semi = EnumSet.allOf(Carta.Seme.class);
        for (Carta.Seme seme : semi) {
            for (int i = 1; i <= 13; i++) {
                Carta.Nome nome = Carta.Nome.values()[i - 1];
                if (i == 1) {
                    //asso
                    ArrayList<Integer> valori = new ArrayList<>(2);
                    valori.add(1);
                    valori.add(11);
                    carte.add(new Carta(seme, i, nome, valori));
                } else if (i >= 10) {
                    //figure
                    carte.add(new Carta(seme, 10, nome));
                } else {
                    Carta carta = new Carta(seme, i, nome);
                    carte.add(carta);
                }
            }
        }
    }

    /**
     * pesca una carta eliminandola dal mazzo. Quando si pesca l'ultima carta,
     * il mazzo viene ricreato
     * @param coperta indica se carta pescata è coperta o scoperta
     * @return 
     */
    public Carta pesca(boolean coperta) {
        Random rnd = new Random();
        int index = rnd.nextInt(carte.size());
        Carta result = carte.get(index);
        result.setCoperta(coperta);
        carte.remove(index);
        if (carte.isEmpty()) {
            crea();
        }
        return result;
    }

    /**
     * ritorna il numero di carte presenti nel mazzo
     * @return 
     */
    public int numeroCarte() {
        return carte.size();
    }

    
    /*
    ------------------------------ tostring ------------------------------------
    */
    @Override
    public String toString() {
        String result = "";
        for (Carta carta : carte) {
            result += carta.toString() + "\n";
        }
        return result;
    }

}
