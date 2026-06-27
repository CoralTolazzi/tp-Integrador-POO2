package cicloDeVidaDelPedido;

import catalogoDeProductos.Producto;

public class Borrador extends Estado {

    public Borrador(Pedido pedido) {
        setPedido(pedido);
    }

    @Override
    public void siguienteEstado() {
        Estado siguienteEstado = new Confirmado(getPedido());
        getPedido().cambiarEstado(siguienteEstado);
    }

    @Override
    public void agregarProducto(Producto producto) {
        getPedido().agregarProductoAlCarrito(producto);
    }
}
