package tpi_unq_shop;

import catalogoDeProductos.Producto;

public class CriterioPorDisponibilidad implements CriterioDeBusqueda{
    private final double disponibilidadBuscada;

    public CriterioPorDisponibilidad(double disponibilidad){
        this.disponibilidadBuscada = disponibilidad;
    }

    public boolean cumple(Producto producto) {
        return (double) producto.getAtributo("stock") >= this.disponibilidadBuscada;
    }
}
