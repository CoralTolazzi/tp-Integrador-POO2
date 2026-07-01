package notificacionesDelPedido;

public class GeneradorFactura extends ObservadorPedido {

    @Override
    public void actualizar() {
        pedido.getEstado().generarFactura(this);
    }

    public void generarFacturaDeEntrega() {
        mailSender.enviarMail(pedido.getDireccionEnvio(),"Factura","El Precio De Tu Producto Fue:" + pedido.getPrecio() +  "." ,"");
    }
}
