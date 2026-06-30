package catalogoDeProductos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public class Catalogo {
    HashMap<Producto, Integer> stock;


    public Catalogo(){
        setStock(new HashMap<>());
    }

    public void agregarProducto(Producto producto) {
        getStock().put(producto,(getStock().getOrDefault(producto,0)+1));
    }

    public  Integer verStockDe(Producto producto){
        return getStock().get(producto);
    }

    public void quitarProducto(Producto producto){
        if(getStock().containsKey(producto)){
            getStock().put(producto,(getStock().get(producto))-1);
        }
    }

    public boolean hayStockDisponible(Producto producto) {
        return getStock().getOrDefault(producto,0) != 0;
    }
}
