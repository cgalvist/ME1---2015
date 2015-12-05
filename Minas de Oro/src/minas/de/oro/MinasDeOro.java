package minas.de.oro;

public class MinasDeOro {

    public static void main(String[] args) {
        
        int largoTerreno = 30;
        int anchoTerreno = 40;
        
        int valorOro = 3;
        int valorPlata = 2;
        int valorBronce = 1;
        
        int maximaCantidad = 50;
        
        Terreno terreno = new Terreno(largoTerreno, anchoTerreno);
        
        terreno.llenarTerreno(valorOro, valorPlata, valorBronce, maximaCantidad);
        
        terreno.imprimirTerreno();
    }
    
}
