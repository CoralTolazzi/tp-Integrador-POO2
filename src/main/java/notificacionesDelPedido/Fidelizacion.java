package notificacionesDelPedido;

public class Fidelizacion extends ObservadorPedido {

    public void envioDescuentoFidelizacion() {
        mailSender.enviarMail(pedido.getDireccionEnvio(),"Lamentamos la cancelacion","5% descuento", "");
    }

    public void actualizar() {
        pedido.getEstado().fidelizacionDelPedido(this);
    }
}
