package tpi_unq_shop;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;

import java.util.List;

public class CriterioOR implements CriterioDeBusqueda{
    private final List<CriterioDeBusqueda> criterios;

    public CriterioOR(List<CriterioDeBusqueda> criterios){
        this.criterios = criterios;
    }

    public boolean cumple(Producto producto, Catalogo c) {
        return criterios.stream().anyMatch(cr -> cr.cumple(producto,  c));
    }
}
