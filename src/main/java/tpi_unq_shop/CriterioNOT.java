package tpi_unq_shop;

import catalogoDeProductos.Producto;

public class CriterioNOT implements CriterioDeBusqueda{
    private final CriterioDeBusqueda criterioANegar;

    public CriterioNOT(CriterioDeBusqueda criterio){
        this.criterioANegar = criterio;
    }

    public boolean cumple(Producto producto) {
        return !this.criterioANegar.cumple(producto);
    }
}
