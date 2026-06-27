package tpi_unq_shop;

import CatalogoDeProductos.Producto;

import java.util.List;

public class CriterioAND implements CriterioDeBusqueda{
    private List<CriterioDeBusqueda> criterios;

    public CriterioAND(List<CriterioDeBusqueda> criterios){
        this.criterios = criterios;
    }

    public boolean cumple(Producto producto) {
        return criterios.stream().allMatch(c -> c.cumple(producto));
    }
}
