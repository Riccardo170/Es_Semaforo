/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_4_prodcons;

import static java.lang.Thread.sleep;

/**
 *
 * @author Utente
 */
public class Es_4_ProdCons {
    
static int[] buffer = new int[10]; 
static int conta; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        Semaforo pieno = new Semaforo(0); // consumatore
        Semaforo vuoto = new Semaforo(1); // produttore
        Thread t1= new Thread(new ProduttoreDato(pieno, vuoto));
        Thread t2= new Thread(new ConsumatoreDato(pieno, vuoto,"Consumatore1"));
        Thread t3= new Thread(new ConsumatoreDato(pieno, vuoto,"Consumatore2"));
        Thread t4= new Thread(new ConsumatoreDato(pieno, vuoto,"Consumatore3"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        sleep(1000);
        
        t1.stop();
        t2.stop();
        t3.stop();
        t4.stop();
    }
    
}
