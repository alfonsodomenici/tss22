/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oo_bj;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Mazzo mazzo = new Mazzo();

        Giocatore g = new Giocatore("Rossi");
        Banco b = new Banco();

        do {
            if (mazzo.numeroCarte() < 20) {
                mazzo.crea();
            }

            initMano(b, g, mazzo);

            giocaMano(g, mazzo);
            
            if (g.isOut()) {
                g.decrementaSoldi();
                System.out.println("soldi giocatore: " + g.getSoldi());
                continue;
            }
            
            giocaMano(b, mazzo);
            
            if (b.isOut() || b.valoreMano() < g.valoreMano()) {
                g.incrementaSoldi();
                //stampaMano
            } else if (b.valoreMano() > g.valoreMano()) {
                g.decrementaSoldi();
            }
            System.out.println("soldi giocatore: " + g.getSoldi());

        } while (g.isContinuaPartita());

    }

    private static void initMano(Banco b, Giocatore g, Mazzo mazzo) {
        System.out.println("------------------- Nuova Mano ---------------------");
        b.initMano();
        g.initMano();
        g.addCarta(mazzo.pesca(false));
        g.addCarta(mazzo.pesca(false));
        b.addCarta(mazzo.pesca(false));
        b.addCarta(mazzo.pesca(true));
        System.out.println(g.toString() + " - " + b.toString());
    }

    private static void giocaMano(AbstractGiocatore ag, Mazzo mazzo) throws InterruptedException {
        System.out.print(ag.toString());
        while (ag.isContinuaMano() && !ag.isOut()) {
            Thread.sleep(3000);
            Carta c = mazzo.pesca(false);
            ag.addCarta(c);
            System.out.print(c.toString() + ",");
        }
        System.out.println();
    }
}
