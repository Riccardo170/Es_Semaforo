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
public class ConsumaDato extends Thread {
    Semaforo pieno;
    Semaforo vuoto;
    int dato=0;

    public ConsumaDato(Semaforo s1, Semaforo s2) {
        pieno=s1;
        vuoto=s2;
    }
    
    public void Run(){
        while(dato!=ProduciDato.tanti-1){
            pieno.P(); // occupa la risorsa
            dato=ProdConsSem.buffer;
            System.out.println("Lettore: dato letto :" + dato);
            vuoto.V(); //da il verde al produttore
        }
    }
    
    
    
}
