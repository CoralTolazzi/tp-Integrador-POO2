package cicloDeVidaDelPedido;

import catalogoDeProductos.Producto;
import notificacionesDelPedido.NotificadorEmail;

public class Borrador extends Estado {

    public Borrador(Pedido pedido) {
        setPedido(pedido);
    }


    @Override
    public void siguienteEstado() {
        Estado siguienteEstado = new Confirmado(getPedido());
        NotificadorEmail notificadorEmail = new NotificadorEmail();
        getPedido().getObservadores().add(notificadorEmail);
        notificadorEmail.setPedido(getPedido());
        notificadorEmail.setMailSender(getPedido().getMail());
        this.getPedido().cambiarEstado(siguienteEstado);
    }

    @Override
    public void agregarProducto(Producto producto) {
        this.getPedido().agregarProductoAlCarrito(producto);
    }


}
