package minas.de.oro;

import minas.de.oro.agente.AgenteMina;

public class MinasDeOro {

    public static void main(String[] args) {
        
        int largoTerreno = 20;
        int anchoTerreno = 30;
        
        int valorOro = 3;
        int valorPlata = 2;
        int valorBronce = 1;
        
        int maximaCantidad = 10;
        
        Terreno terreno = new Terreno(largoTerreno, anchoTerreno);
        
        terreno.llenarTerreno(valorOro, valorPlata, valorBronce, maximaCantidad);
        
        terreno.imprimir();
        
        int[] posicionAgente = {0,0}; 
        
        AgenteMina agente = new AgenteMina(1, 100, 0, posicionAgente);
        
        agente.accion(terreno);
        
        System.out.println("proceso terminado");
    }
    
}
