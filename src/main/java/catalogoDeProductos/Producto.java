package catalogoDeProductos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Producto {
    public String nombre;
    public String descripcion;
    public double descuento;

    //getters
    public abstract double getPrecioBase();

    public abstract double getPrecioFinal();

    public abstract double getPeso();

}
