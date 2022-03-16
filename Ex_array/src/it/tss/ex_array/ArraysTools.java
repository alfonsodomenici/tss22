/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex_array;

import java.util.Random;

/**
 *
 * @author tss
 */
public class ArraysTools {

    public static void stampa(int[] numeri) {
        for (int i = 0; i < numeri.length; i++) {
            if (i == numeri.length - 1) {
                System.out.print(numeri[i]);
            } else {
                System.out.print(numeri[i] + ",");
            }

        }
        System.out.println("");
    }

    public static void stampa1(int[] numeri) {
        for (int i = 0; i < numeri.length; i++) {
            String separatore = (i == numeri.length - 1) ? "" : ",";
            System.out.print(numeri[i] + separatore);
        }
        System.out.println("");
    }

    public static void stampaNumeriIndiceDispari(int[] numeri) {
        for (int i = 0; i < numeri.length; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.print(numeri[i] + ",");
        }
        System.out.println("");
    }

    public static boolean ricerca(int[] numeri, int n) {
        boolean ris = false;
        int idx = 0;
        while (idx < numeri.length && !ris) {
            ris = numeri[idx] == n;
            idx++;
        }
        return ris;
    }

    public static boolean ricerca1(int[] numeri, int n) {
        boolean ris = false;
        for (int idx = 0; idx < numeri.length; idx++) {
            if (numeri[idx] == n) {
                ris = true;
                break;
            }
        }
        return ris;
    }

    public static boolean ricerca2(int[] numeri, int n) {
        for (int idx = 0; idx < numeri.length; idx++) {
            if (numeri[idx] == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * ritorna l'indice dell'elemento trovato altrimenti -1
     *
     * @param numeri
     * @param n
     * @return
     */
    public static int indexOf(int[] numeri, int n) {
        return indexOf(0, numeri, n);
    }

    /**
     * ritorna l'indice dell'elemento trovato altrimenti -1
     *
     * @param start indice dal quale partire con la ricerca
     * @param numeri
     * @param n
     * @return
     */
    public static int indexOf(int start, int[] numeri, int n) {
        for (int idx = start; idx < numeri.length; idx++) {
            if (numeri[idx] == n) {
                return idx;
            }
        }
        return -1;
    }

    public static int max(int[] numeri) {
        int max = 0;
        for (int i = 0; i < numeri.length; i++) {
            max = i == 0 ? numeri[i] : numeri[i] > max ? numeri[i] : max;
        }
        return max;
    }

    public static int min(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("impossibile calcolare il minimo, array nullo o vuoto");
        }
        int min = numeri[0];
        int indice = 1;
        while (indice < numeri.length) {
            if (numeri[indice] < min) {
                min = numeri[indice];
            }
            indice = indice + 1;
        }
        return min;
    }

    public static int somma(int[] numeri) {
        int ris = 0;
        for (int i = 0; i < numeri.length; i++) {
            ris += numeri[i];
        }
        return ris;
    }

    public static double media(int[] numeri) {
        if (numeri == null || numeri.length == 0) {
            throw new IllegalArgumentException("Impossibile calcolare la media");
        }
        return (double) somma(numeri) / numeri.length;
    }

    /**
     * ritorna una copia dell'array numeri
     *
     * @param numeri
     * @return
     */
    public static int[] copia(int[] numeri) {
        int[] ris = new int[numeri.length];
        for (int i = 0; i < ris.length; i++) {
            ris[i] = numeri[i];
        }
        return ris;
    }

    /**
     * ritorna un array contenente l'unione di numeri1 e numeri2
     *
     * @param numeri1
     * @param numeri2
     * @return
     */
    public static int[] unisci(int[] numeri1, int[] numeri2) {
        int[] ris = new int[numeri1.length + numeri2.length];
        for (int i = 0; i < numeri1.length; i++) {
            ris[i] = numeri1[i];
        }
        for (int i = 0; i < numeri2.length; i++) {
            ris[numeri1.length + i] = numeri2[i];
        }
        return ris;
    }

    /**
     * ritorna un array contenente l'unione di numeri1 e numeri2
     *
     * @param numeri1
     * @param numeri2
     * @return
     */
    public static int[] unisci1(int[] numeri1, int[] numeri2) {
        int[] ris = new int[numeri1.length + numeri2.length];
        for (int i = 0; i < ris.length; i++) {
            int[] tmp = i < numeri1.length ? numeri1 : numeri2;
            int indice = i < numeri1.length ? i : i - numeri1.length;
            ris[i] = tmp[indice];
        }
        return ris;
    }

    /**
     * ritorna true se numeri1 contiene numeri2 nella sequenza corretta
     *
     * @param numeri1
     * @param numeri2
     * @return
     */
    public static boolean contieneSequenza(int[] numeri1, int[] numeri2) {
        if (numeri2.length == 0) {
            return false;
        }
        if (numeri2.length > numeri1.length) {
            return false;
        }
        boolean ris = false;
        int n = numeri2[0];
        int start = indexOf(numeri1, n);
        while (start != -1 && numeri1.length >= start + numeri2.length && !ris) {
            ris = true;
            for (int i = 0; i < numeri2.length; i++) {
                if (numeri1[start + i] != numeri2[i]) {
                    ris = false;
                    break;
                }
            }
            start = indexOf(start + 1, numeri1, n);
        }
        return ris;
    }

    /**
     * ritorna true se numeri1 contiene tutti i valori di numeri2 in qualunque
     * sequenza
     *
     * @param numeri1
     * @param numeri2
     * @return
     */
    public static boolean contieneValori(int[] numeri1, int[] numeri2) {
        boolean ris = true;
        for (int n : numeri2) {
            if (ricerca(numeri1, n) == false) {
                ris = false;
                break;
            }
        }
        return ris;
    }

    /**
     * ritorna un array con solo i valori contenuti in entrambi gli array
     * sequenza
     *
     * @param numeri1
     * @param numeri2
     * @return
     */
    public static int[] intersezione(int[] numeri1, int[] numeri2) {
        int[] ris = {};
        for (int n : numeri1) {
            if (ricerca(ris, n) == false && ricerca(numeri2, n) == true) {
                int[] tmp = new int[1];
                tmp[0] = n;
                ris = unisci(ris, tmp);
            }
        }
        return ris;
    }

    public static void ordinaBubble(int[] numeri) {
        boolean ordinato;
        do {
            ordinato = true;
            int indice = 0;
            while (indice < numeri.length - 1) {
                if (numeri[indice] > numeri[indice + 1]) {
                    int tmp = numeri[indice];
                    numeri[indice] = numeri[indice + 1];
                    numeri[indice + 1] = tmp;
                    ordinato = false;
                }
                indice = indice + 1;
            }
        } while (!ordinato);
    }
    
    public static int[] generaArrayCasuale(int ncelle, int max) {
        int[] ris = new int[ncelle];
        for (int i = 0; i < ris.length; i++) {
            ris[i] = generaNumeroCasuale(max);
        }
        return ris;
    }

    public static int generaNumeroCasuale(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
