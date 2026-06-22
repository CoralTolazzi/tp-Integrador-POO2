package tpi_unq_shop;

import CatalogoDeProductos.Producto;

public interface CriterioDeBusqueda {
    public boolean cumple(Producto producto);
}
