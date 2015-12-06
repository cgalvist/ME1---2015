package minas.de.oro;

import java.util.ArrayList;
import minas.de.oro.agente.AgenteMina;

public class MinasDeOro {

    public static void main(String[] args) {
        
        int largoTerreno = 10;
        int anchoTerreno = 15;
        
        int valorOro = 3;
        int valorPlata = 2;
        int valorBronce = 1;
        
        int maximaCantidad = 10;
        
        Terreno terreno = new Terreno(largoTerreno, anchoTerreno);
        
        terreno.llenarTerreno(valorOro, valorPlata, valorBronce, maximaCantidad);
        
        terreno.imprimir();
        
        int[] posicionAgente = {0,0}; 
        
        int numeroDeAgentes = 10;
        int vidaDelAgente = 100;
        
        ArrayList<AgenteMina> agentes = new ArrayList<AgenteMina>();
        
        for (int i = 1; i <= numeroDeAgentes; i++) {
            agentes.add(new AgenteMina(i, vidaDelAgente, 0, posicionAgente));
        }
        
        for (AgenteMina agente : agentes) {
            agente.accion(terreno);
        }
        
        System.out.println("proceso terminado");
        
        terreno.imprimir();
    }
    
}
