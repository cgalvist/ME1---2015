package minas.de.oro;

public class Mina implements Cloneable{
    private int tipo;   //0 es vacio, 1 es oro, 2 es plata y 3 es bronce
    private int cantidad;
    private int valor;
    private int idPropietario = 0;

    public Mina(int tipo, int cantidad, int valor) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.valor = valor;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
    
    public int extraer(){
        cantidad--;
        return valor;
    }
    
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
}
