package tpi_unq_shop;

import CatalogoDeProductos.Producto;

public class CriterioPorPrecioMaximo implements CriterioDeBusqueda{
    private double precioABuscar;

    public CriterioPorPrecioMaximo(double precio){
        this.precioABuscar = precio;
    }

    public boolean cumple(Producto producto) {
        return producto.getPrecioFinal() <= this.precioABuscar;
    }
}
