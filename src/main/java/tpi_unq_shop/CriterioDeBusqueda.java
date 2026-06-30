package tpi_unq_shop;

import catalogoDeProductos.Producto;

public interface CriterioDeBusqueda {
    boolean cumple(Producto producto);
}
