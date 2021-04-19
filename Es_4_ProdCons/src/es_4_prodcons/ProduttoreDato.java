/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_4_prodcons;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Utente
 */
public class ProduttoreDato implements Runnable{
   Semaforo pieno;
    Semaforo vuoto;
    int tanti=0; //numeri di elementi da produrre partendo da 0
    final int attesa = 500; //tempo di risposta attesa

    public ProduttoreDato(Semaforo pieno, Semaforo vuoto) {
        this.pieno = pieno;
        this.vuoto = vuoto;
    }

    @Override
    public void run() {
        while(true){
            try {
                vuoto.P(); // occupa la risorsa
            } catch (InterruptedException ex) {
                Logger.getLogger(ProduttoreDato.class.getName()).log(Level.SEVERE, null, ex);
            }
            Es_4_ProdCons.buffer[tanti]=(int) (Math.random()*10);
            System.out.println("Scrittore: dato scritto :" + Es_4_ProdCons.buffer[tanti]);
            tanti=tanti+1;
            pieno.V(); // da il verde al consumatore

            try {
                sleep(attesa);
            } catch (InterruptedException e) {
                Logger.getLogger(ProduttoreDato .class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

}


 

