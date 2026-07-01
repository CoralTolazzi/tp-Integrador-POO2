package catalogoDeProductos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public abstract class Producto {
    String nombre;
    String descripcion;
    double descuento;
    String categoria;
    Map<String,Object> atributosDinamicos = new HashMap<>();

    // Getters
    public abstract double getPrecioBase();
    public abstract double getPrecioFinal();
    public abstract double getPeso();


}