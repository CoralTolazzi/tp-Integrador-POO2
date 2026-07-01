package notificacionesDelPedido;


import envio.Direccion;

public interface MailSender {

         void enviarMail(Direccion direccionDestino, String titulo, String mensaje, String adjunto);
}
