package tpi_unq_shop;

import CatalogoDeProductos.Producto;

public class CriterioPorDisponibilidad implements CriterioDeBusqueda{
    private double disponibilidadBuscada;

    public CriterioPorDisponibilidad(double disponibilidad){
        this.disponibilidadBuscada = disponibilidad;
    }

    public boolean cumple(Producto producto) {
        return producto.getStock() >= this.disponibilidadBuscada;
    }
}
