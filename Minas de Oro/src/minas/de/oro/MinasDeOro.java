package minas.de.oro;

import java.util.ArrayList;
import minas.de.oro.agente.AgenteMina;

public class MinasDeOro {

private static Terreno terreno;

    public static void main(String[] args) {
        
        int largoTerreno = 10;
        int anchoTerreno = 15;
        
        int valorOro = 3;
        int valorPlata = 2;
        int valorBronce = 1;
        
        int maximaCantidad = 10;
        
        terreno = new Terreno(largoTerreno, anchoTerreno);
        
        terreno.llenarTerreno(valorOro, valorPlata, valorBronce, maximaCantidad);
        
//        terreno.imprimir();
        
        int[] posicionAgente = {0,0}; 
        
        int numeroDeAgentes = 10;
        int vidaDelAgente = 100;
        
        ArrayList<AgenteMina> agentes = new ArrayList<>();
        
        for (int i = 1; i <= numeroDeAgentes; i++) {
            agentes.add(new AgenteMina(i, vidaDelAgente, 0, posicionAgente));
        }
        
        for (AgenteMina agente : agentes) {
            agente.start();
        }
        
        System.out.println("proceso terminado");
        
//        terreno.imprimir();
    }

    public static Terreno getTerreno() {
        return terreno;
    }

    public static void setTerreno(Terreno aTerreno) {
        terreno = aTerreno;
    }
    
}
