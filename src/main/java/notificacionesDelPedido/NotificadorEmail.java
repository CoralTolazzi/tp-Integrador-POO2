package notificacionesDelPedido;


public class NotificadorEmail extends ObservadorPedido {

    public void notificionEstadoConfirmado() {
        mailSender.enviarMail("dir1", "Confirmado", "Tu pedido fue confirmado", null);
    }

    public void notificionEstadoEnviado() {
        mailSender.enviarMail("dir1", "Enviado", "Tu pedido está en viaje", null);
    }

    public void notificacionEstadoEntregado() {
        mailSender.enviarMail("dir1", "Entregado", "¡Gracias por tu compra!", null);
    }

    public void actualizar() {
        pedido.getEstado().emailNotificacion(this);
    }
}
