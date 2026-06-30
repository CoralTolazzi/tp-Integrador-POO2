package tpi_unq_shop;

import catalogoDeProductos.Producto;

public class CriterioPorNombre implements CriterioDeBusqueda{
    private final String textoABuscar;

    public CriterioPorNombre(String textoABuscar){
        this.textoABuscar = textoABuscar;
    }

    public boolean cumple(Producto producto){
        return producto.getNombre().contains(this.textoABuscar);
    }
}
