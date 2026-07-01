package tpi_unq_shop;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;

public class CriterioPorDisponibilidad implements CriterioDeBusqueda{
    private final double disponibilidadBuscada;

    public CriterioPorDisponibilidad(double disponibilidad){
        this.disponibilidadBuscada = disponibilidad;
    }

    public boolean cumple(Producto producto, Catalogo c) {
        return (double) c.verStockDe(producto) >= this.disponibilidadBuscada;


    }
}
