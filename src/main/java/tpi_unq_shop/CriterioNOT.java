package tpi_unq_shop;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;

public class CriterioNOT implements CriterioDeBusqueda{
    private final CriterioDeBusqueda criterioANegar;

    public CriterioNOT(CriterioDeBusqueda criterio){
        this.criterioANegar = criterio;
    }

    public boolean cumple(Producto producto, Catalogo c) {
        return !this.criterioANegar.cumple(producto,c);
    }
}
