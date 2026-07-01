package notificacionesDelPedido;


public class NotificadorEmail extends ObservadorPedido {

    public void notificionEstadoConfirmado() {
        mailSender.enviarMail(pedido.getDireccionEnvio(), "Confirmado", "Tu pedido fue confirmado", null);
    }

    public void notificionEstadoEnviado() {
        mailSender.enviarMail(pedido.getDireccionEnvio(), "Enviado", "Tu pedido está en viaje", null);
    }

    public void notificacionEstadoEntregado() {
        mailSender.enviarMail(pedido.getDireccionEnvio(), "Entregado", "¡Gracias por tu compra!", null);
    }

    public void actualizar() {
        pedido.getEstado().emailNotificacion(this);
    }
}
