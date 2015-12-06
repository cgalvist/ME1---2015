/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas.de.oro.agente;

import java.util.Random;
import minas.de.oro.Mina;
import minas.de.oro.Terreno;

/**
 *
 * @author cesar
 */
public class AgenteMina {
    
    private int id;
    private int tiempoDeVida;
    private int dinero;
    private int[] posicion;
        
    public AgenteMina(int id, int tiempoDeVida, int dinero, int[] posicion) {
        this.id = id;
        this.tiempoDeVida = tiempoDeVida;
        this.dinero = dinero;
        this.posicion = posicion;
    }
    
    //acciones
    
    public void accion(Terreno terreno){
        
        Mina minaTemporal = null;
        Random random = new Random();
        int largo = terreno.getLargo();
        int ancho = terreno.getAncho();
        
        while(tiempoDeVida > 0) {
            
            minaTemporal = terreno.getMina(posicion[0], posicion[1]);

            //si la mina en la que estoy tiene minerales y no tiene due%o
            //la puedo explotar
            if (minaTemporal.getTipo() > 0 && minaTemporal.getIdPropietario() != 0) {
                minaTemporal.setIdPropietario(id);

                while (minaTemporal.getCantidad() > 0) {
                    dinero += minaTemporal.extraer();
                }
                minaTemporal.setTipo(0);
                minaTemporal.setIdPropietario(0);
            } 

            //si no tiene minerales o ya tiene due%o, mejor busco algo en otra parte
            else {
                
                while(!(posicion[0] >= 0 && posicion[0] <= largo &&  posicion[1] >= 0 && posicion[1] <= ancho)){
                    posicion[0] = posicion[0] + (random.nextInt(2) - 1);
                    posicion[1] = posicion[1] + (random.nextInt(2) - 1);
                }
            }
            tiempoDeVida--;
        }
    }
}
