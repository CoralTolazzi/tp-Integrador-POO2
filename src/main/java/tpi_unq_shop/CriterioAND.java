package tpi_unq_shop;

import catalogoDeProductos.Producto;

import java.util.List;

public class CriterioAND implements CriterioDeBusqueda{
    private final List<CriterioDeBusqueda> criterios;

    public CriterioAND(List<CriterioDeBusqueda> criterios){
        this.criterios = criterios;
    }

    public boolean cumple(Producto producto) {
        return criterios.stream().allMatch(c -> c.cumple(producto));
    }
}
