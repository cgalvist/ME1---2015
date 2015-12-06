package minas.de.oro;


public class Terreno {
    private int largo;
    private int ancho;
    private Mina[][] terreno;
    
    public Terreno(int alto, int ancho){
        this.largo = alto;
        this.ancho = ancho;
        
        iniciarTerreno();
        
    }
    
    private void iniciarTerreno() {
        terreno = new Mina[largo][ancho];

        for (int a = 0; a < largo; a++) {
            for (int b = 0; b < ancho; b++) {
                terreno[a][b] = new Mina(0,0,0);
            }
        }
    }

    public void llenarTerreno(int valorOro, int valorPlata, int valorBronce, int maximaCantidad) {
        double p;
        int cantidad;
        for (int a = 0; a < largo; a++) {
            for (int b = 0; b < ancho; b++) {
                p = Math.random();
                cantidad = (int) (Math.random()*(maximaCantidad-1)+1);
                //esto hay que cambiarlo por la distribucion de probabilidad requerida
                if (p < 0.25) {
                    terreno[a][b] = new Mina(1, cantidad, valorOro);
                }
                if (0.25 <= p && p < 0.5) {
                    terreno[a][b] = new Mina(2, cantidad, valorPlata);
                }
                if (0.5 <= p && p <= 0.75) {
                    terreno[a][b] = new Mina(3, cantidad, valorBronce);
                }
            }
        }
    }
    
    public void imprimir(){
        for (int a = 0; a < largo; a++) {
            for (int b = 0; b < ancho; b++) {
                System.out.print(terreno[a][b].getTipo()+" ");
            }
            System.out.println();
        }
    }    
    
//    private int obtenerPoisson(double lambda) {
//        double L = Math.exp(-lambda);
//        double p = 1.0;
//        int k = 0;
//
//        do {
//            k++;
//            p *= Math.random();
//        } while (p > L);
//
//        return k - 1;
//    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public Mina[][] getTerreno() {
        return terreno;
    }

    public void setTerreno(Mina[][] terreno) {
        this.terreno = terreno;
    }
    
    public Mina getMina(int largo, int ancho) {
        return terreno[largo][ancho];
    }
}
