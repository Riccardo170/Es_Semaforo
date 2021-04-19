/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_4_prodcons;


import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Utente
 */
public class ConsumatoreDato implements Runnable{
    Semaforo pieno;
    Semaforo vuoto;
    int dato;

    public ConsumatoreDato(Semaforo pieno, Semaforo vuoto, String nome) {
        this.pieno = pieno;
        this.vuoto = vuoto;
        
    }

    @Override
    public void run() {
        while(true){
            try {
                pieno.P(); // occupa la risorsa
            } catch (InterruptedException e) {
                Logger.getLogger(ConsumatoreDato.class.getName()).log(Level.SEVERE, null, e);
            }
            Es_4_ProdCons.buffer[dato]=0;
            dato=dato+1;
            System.out.println("Lettore: dato letto :" + dato);
            vuoto.V(); //da il verde al produttore
        }
    }

} 