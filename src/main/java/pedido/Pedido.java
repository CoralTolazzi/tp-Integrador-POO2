package pedido;

import lombok.Getter;
import producto.Producto;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pedido {
    private final List<Producto> compras = new ArrayList<>();

    public double getPeso() {
        return compras.stream().mapToDouble(Producto::getPeso).sum();
    }

    public Direccion getDireccionEnvio() {
        return null;
    }

    public double getPrecio() {
        return compras.stream().mapToDouble(Producto::getPrecio).sum();
    }
}
