package CicloDeVidaDelPedido;

import CatalogoDeProductos.Producto;

public abstract class Estado {
    public Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void siguienteEstado();

    public void cancelarPedido(){
        Estado estadoCancelado = new Cancelado();
        getPedido().cambiarEstado(estadoCancelado);
    }

    public void agregarProducto(Producto producto) {}
}
