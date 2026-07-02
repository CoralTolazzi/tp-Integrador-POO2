package envio;

import catalogoDeProductos.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sucursal {
    private Map<Producto, Integer> stock = new HashMap<>();

    public void agregarStock(Producto producto, int cantidad) {
        stock.put(producto, stock.getOrDefault(producto, 0) + cantidad);
    }

    public boolean hayStockDe(Producto producto) {
        return stock.getOrDefault(producto, 0) > 0;
    }

    public boolean tieneTodo(List<Producto> productos) {
        return productos.stream().allMatch(this::hayStockDe);
    }
}