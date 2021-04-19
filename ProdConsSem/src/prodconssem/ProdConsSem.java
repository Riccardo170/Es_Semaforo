/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodconssem;

/**
 *
 * @author Utente
 */
public class ProdConsSem {
    protected static int buffer;              // variabile globale
    
    public static void main(String[] args) {
        Semaforo pieno = new Semaforo(0);    //inizialmente rosso
        Semaforo vuoto = new Semaforo(1);    //inizialmente vuoto
        ProduciDato prod= new ProduciDato(pieno, vuoto);
        ConsumaDato cons = new ConsumaDato(pieno,vuoto);
        prod.start();
        cons.start();
        System.out.println("Main: termine avvio thread.");
        
    }
    
}
