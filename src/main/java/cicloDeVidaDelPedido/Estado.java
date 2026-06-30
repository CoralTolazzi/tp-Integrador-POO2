package cicloDeVidaDelPedido;

import catalogoDeProductos.Producto;
import lombok.Getter;
import lombok.Setter;
import notificacionesDelPedido.Fidelizacion;
import notificacionesDelPedido.GeneradorFactura;
import notificacionesDelPedido.NotificadorEmail;

@Getter
@Setter
public abstract class Estado {
    public Pedido pedido;

    public abstract void siguienteEstado();

    public void cancelarPedido(){
        Cancelado estadoCancelado = new Cancelado();
        this.getPedido().setEstado(estadoCancelado);
        estadoCancelado.setPedido(pedido);
        this.cancelacionDePedido(estadoCancelado);
    }

    public void agregarProducto(Producto producto) {}

    protected void cancelacionDePedido(Cancelado estadoCancelado) {}

    public void emailNotificacion(NotificadorEmail observador){}

    public void generarFactura(GeneradorFactura generadorFactura) {}

    public void fidelizacionDelPedido(Fidelizacion fidelizacion) {}
}
