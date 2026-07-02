package cicloDeVidaDelPedido;

import catalogoDeProductos.Producto;
import notificacionesDelPedido.NotificadorEmail;

import java.util.List;

public class Confirmado extends Estado {
    public Confirmado(Pedido pedido) {
        this.setPedido(pedido);
        decrementarStockDeCatalogo(getPedido().getCarrito());
        pedido.pagarPedido(pedido.getMedioDePago());
    }

    @Override
    public void siguienteEstado() {
        Estado siguienteEstado = new En_Preparacion(getPedido());
        this.getPedido().cambiarEstado(siguienteEstado);
    }

    private void decrementarStockDeCatalogo(List<Producto> carrito) {
        carrito.forEach(producto -> getPedido().getCatalogo().quitarProducto(producto));
    }

    @Override
    protected void cancelacionDePedido(Cancelado estadoCancelado) {
        estadoCancelado.protocoloDeCancelamientoDeConfirmado();
    }

    @Override
    public void cancelarPedido() {
        Cancelado estadoCancelado = new Cancelado();
        this.getPedido().cambiarEstado(estadoCancelado);
        estadoCancelado.setPedido(this.getPedido());
        estadoCancelado.protocoloDeCancelamiento(this);

    }

    @Override
    public void emailNotificacion(NotificadorEmail observador) {
        observador.notificionEstadoConfirmado();
    }
}
