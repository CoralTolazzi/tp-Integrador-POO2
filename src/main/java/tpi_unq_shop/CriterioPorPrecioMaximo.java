package tpi_unq_shop;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;

public class CriterioPorPrecioMaximo implements CriterioDeBusqueda{
    private final double precioABuscar;

    public CriterioPorPrecioMaximo(double precio){
        this.precioABuscar = precio;
    }

    public boolean cumple(Producto producto, Catalogo c) {
        return producto.getPrecioFinal() <= this.precioABuscar;
    }
}
