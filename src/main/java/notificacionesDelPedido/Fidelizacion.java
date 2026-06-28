package notificacionesDelPedido;

public class Fidelizacion extends ObservadorPedido {

    public void envioDescuentoFidelizacion() {
        mailSender.enviarMail("direccion","Lamentamos la cancelacion","5% descuento", "A");
    }

    public void actualizar() {
        pedido.getEstado().fidelizacionDelPedido(this);
    }
}
