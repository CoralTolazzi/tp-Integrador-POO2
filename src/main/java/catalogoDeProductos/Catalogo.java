package catalogoDeProductos;

import lombok.Getter;
import lombok.Setter;
import tpi_unq_shop.CriterioDeBusqueda;

import java.util.HashMap;

@Setter
@Getter
public class Catalogo {
    HashMap<Producto, Integer> stock;
    CriterioDeBusqueda criterio;
    HashMap<Producto, Integer> ventas;

    public Catalogo(){
        setStock(new HashMap<>());
        setVentas(new HashMap<>());
    }

    public void agregarProducto(Producto producto) {
        getStock().put(producto,(getStock().getOrDefault(producto,0)+1));
    }

    public  Integer verStockDe(Producto producto){
        return getStock().get(producto);
    }

    public void quitarProducto(Producto producto){
        if(getStock().containsKey(producto) && (getStock().get(producto) > 0)){
            getStock().put(producto,(getStock().get(producto))-1);
        }
    }

    public boolean hayStockDisponible(Producto producto) {
        return getStock().getOrDefault(producto,0) != 0;
    }

    public void registrarVentaDe(Producto p) {
        getVentas().put(p,(getVentas().getOrDefault(p,0)+1));
    }

    public Integer verVentasDe(Producto p){
        return getVentas().getOrDefault(p,0);
    }
}
