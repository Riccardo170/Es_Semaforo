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
public class Semaforo {
    int valore;                //0=rosso
    
    public Semaforo(int v){
        valore = v;
    }
    
    synchronized public void P(){
        while(valore==0){        // semaforo rosso
            try{wait();}         //sospensione del thread
                catch(InterruptedException e){}
        }
        valore--;
    }
    synchronized public void V(){
        valore++;
        notify();      //risveglia il thread
    }
}
