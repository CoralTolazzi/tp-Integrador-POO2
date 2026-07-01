package tpi_unq_shop;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;

public interface CriterioDeBusqueda {
    boolean cumple(Producto producto, Catalogo catalogo);
}
