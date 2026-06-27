package tpi_unq_shop;

import catalogoDeProductos.Producto;

import java.util.List;

public class CriterioOR implements CriterioDeBusqueda{
    private final List<CriterioDeBusqueda> criterios;

    public CriterioOR(List<CriterioDeBusqueda> criterios){
        this.criterios = criterios;
    }

    public boolean cumple(Producto producto) {
        return criterios.stream().anyMatch(c -> c.cumple(producto));
    }
}
