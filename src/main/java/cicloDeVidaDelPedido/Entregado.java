package cicloDeVidaDelPedido;

import notificacionesDelPedido.GeneradorFactura;
import notificacionesDelPedido.NotificadorEmail;

public class Entregado extends Estado {

    @Override
    public void cancelarPedido() {
    }

    public Entregado(Pedido pedido) {
        setPedido(pedido);
        GeneradorFactura generadorFactura = new GeneradorFactura();
        generadorFactura.setPedido(getPedido());
        generadorFactura.setMailSender(getPedido().getMail());
        pedido.getObservadores().add(generadorFactura);
        pedido.registrarVentas();
        pedido.notificar();
    }

    public void siguienteEstado(){}

    @Override
    public void emailNotificacion(NotificadorEmail observador) {
        observador.notificacionEstadoEntregado();
    }

    @Override
    public void generarFactura(GeneradorFactura generadorFactura) {
        generadorFactura.generarFacturaDeEntrega();
    }
}
