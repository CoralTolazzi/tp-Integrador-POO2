package cicloDeVidaDelPedido;

import catalogoDeProductos.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pedido {
    @Setter public Estado estado;
    List<Producto> carrito = new ArrayList<>();

    public Pedido(){
        setEstado(new Borrador(this));
    }

    // Operaciones
    public void cambiarEstado(Estado siguienteEstado) {
        setEstado(siguienteEstado);
    }

    public void siguientePaso(){
        getEstado().siguienteEstado();
    }

    public void cancelarPedido(){
        getEstado().cancelarPedido();
    }

    public void agregarProducto(Producto producto){
        getEstado().agregarProducto(producto);
    }

    public void agregarProductoAlCarrito(Producto producto) {
        getCarrito().addLast(producto);
    }
}
