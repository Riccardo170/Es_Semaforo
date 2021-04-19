/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es_4_prodcons;

/**
 *
 * @author Utente
 */
public class Semaforo {
    int valore; 
    
    public Semaforo(int v){
        valore=v;
    }
    
    synchronized public void P() throws InterruptedException{
        while(valore==0){
            wait();
        }
        valore--; //mette il semaforo al rosso
    }

    synchronized public void V(){
        valore++;
        notify();
    }
}

