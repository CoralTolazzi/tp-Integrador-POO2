package tpi_unq_shop;

import CatalogoDeProductos.Producto;

public class CriterioNOT implements CriterioDeBusqueda{
    private CriterioDeBusqueda criterioANegar;

    public CriterioNOT(CriterioDeBusqueda criterio){
        this.criterioANegar = criterio;
    }

    public boolean cumple(Producto producto) {
        return !this.criterioANegar.cumple(producto);
    }
}
