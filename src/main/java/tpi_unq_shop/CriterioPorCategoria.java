package tpi_unq_shop;

import catalogoDeProductos.Producto;

public class CriterioPorCategoria implements CriterioDeBusqueda{
    private final String catABuscar;

    public CriterioPorCategoria(String categoria){
        this.catABuscar = categoria;
    }

    public boolean cumple(Producto producto) {
        return this.catABuscar.equals(producto.getCategoria());
    }
}