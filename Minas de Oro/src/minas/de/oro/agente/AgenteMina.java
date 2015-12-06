/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas.de.oro.agente;

import GUI.Inicio;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import minas.de.oro.Mina;
import minas.de.oro.MinasDeOro;
import minas.de.oro.Terreno;

/**
 *
 * @author cesar
 */
public class AgenteMina implements Runnable {
    
    private int id;
    private int vida;
    private int dinero;
    private int[] posicion;
    private Thread hilo;
        
    public AgenteMina(int id, int tiempoDeVida, int dinero, int[] posicion) {
        this.id = id;
        this.vida = tiempoDeVida;
        this.dinero = dinero;
        this.posicion = posicion;
    }
    

    @Override
    public void run() {
//        try {
        
            //        System.out.println("ejecutando agente " + id);
            
            Terreno terreno = Inicio.getTerreno();

            Mina minaTemporal = null;
            Random random = new Random();
            int largo = terreno.getLargo() - 1;
            int ancho = terreno.getAncho() - 1;
            int nuevaFila = -1;
            int nuevaColumna = -1;

            while(vida > 0) {
                
                // vamos a dormir el hilo por un tiempo
//                Thread.sleep(500);

                minaTemporal = terreno.getMina(posicion[0], posicion[1]);

    //            System.out.println(minaTemporal.getCantidad() + " posicion: (" + posicion[0] + "," + posicion[1] + ")");

                //si la mina en la que estoy tiene minerales y no tiene due%o
                //la puedo explotar
                if (minaTemporal.getTipo() > 0 && minaTemporal.getIdPropietario() == 0) {
                    minaTemporal.setIdPropietario(id);

                    while (minaTemporal.getCantidad() > 0) {
                        dinero += minaTemporal.extraer();
                    }
                    minaTemporal.setTipo(0);
                    minaTemporal.setIdPropietario(0);
                } 

                //si no tiene minerales o ya tiene due%o, mejor busco algo en otra parte
                else {

    //                while(!(posicionNueva[0] >= 0 && posicionNueva[0] <= largo 
    //                        &&  posicionNueva[1] >= 0 && posicionNueva[1] <= ancho)
    //                        && (posicion[0] != posicionNueva[0] || posicion[1] != posicionNueva[1])){
                    while(nuevaFila < 0 || nuevaFila > largo 
                            ||  nuevaColumna < 0 || nuevaColumna > ancho
                            || (posicion[0] == nuevaFila && posicion[1] == nuevaColumna)){

                        nuevaFila = posicion[0] + (random.nextInt(3) - 1);
                        nuevaColumna = posicion[1] + (random.nextInt(3) - 1);
                    }
                    posicion[0] = nuevaFila;
                    posicion[1] = nuevaColumna;
                }
                vida--;

    //            System.out.println("dinero: " + dinero + ", posicion: (" + posicion[0] + "," + posicion[1] + ")");
            }
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AgenteMina.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void start () {
//    System.out.println("Iniciando " + id );
    if (hilo == null) {
      hilo = new Thread (this, Integer.toString(id));
      hilo.start ();
    }
  }

    public int getVida() {
        return vida;
    }
}
