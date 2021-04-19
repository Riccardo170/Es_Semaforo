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
public class ProduciDato extends Thread {
    Semaforo pieno;
    Semaforo vuoto;
    static int tanti=5;           //numero totale degli elementi da produrre
    final int attesa=500; //tempo attesa
    
    public ProduciDato(Semaforo s1, Semaforo s2){
        pieno=s1;
        vuoto=s2;
    }
    
    public void run(){
        for(int i=0;i<tanti;i++){
            vuoto.P();
            ProdConsSem.buffer = i;    // produce un numero
            System.out.println("Scrittore: dato scritto :"+i);
            pieno.V();                 //sblocca il consumatore
            try{Thread.sleep(attesa);} // il produttore aspetta che il consumatore legga il dato
            catch (Exception e){}   
        }
        System.out.println("Scrittore: termine scrittura dati.");
    }
}
