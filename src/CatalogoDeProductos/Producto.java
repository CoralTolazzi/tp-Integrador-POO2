package CatalogoDeProductos;

public abstract class Producto {
    public String nombre;
    public String descripcion;
    public double descuento;

    //getters
    public abstract double getPrecioBase();

    public abstract double getPrecioFinal();

    public abstract double getPeso();

    public String getNombre() {
        return nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //seters

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract String getCategoria();

}
