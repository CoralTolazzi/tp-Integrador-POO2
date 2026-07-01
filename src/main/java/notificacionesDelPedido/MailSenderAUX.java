package notificacionesDelPedido;

import envio.Direccion;

public class MailSenderAUX implements MailSender{
    @Override
    public void enviarMail(Direccion direccionDestino, String titulo, String mensaje, String adjunto) {}
}
