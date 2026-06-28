package notificacionesDelPedido;

public class GeneradorFactura extends ObservadorPedido {

    @Override
    public void actualizar() {
        pedido.getEstado().generarFactura(this);
    }

    public void generarFacturaDeEntrega() {
        mailSender.enviarMail("3","4","2","1");
    }
}
