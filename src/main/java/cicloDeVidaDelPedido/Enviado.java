package cicloDeVidaDelPedido;

import notificacionesDelPedido.NotificadorEmail;

public class Enviado extends Estado {
    public Enviado(Pedido pedido) {
        setPedido(pedido);
    }

    public void siguienteEstado() {
        Entregado siguienteEstado = new Entregado(getPedido());
        getPedido().cambiarEstado(siguienteEstado);
    }

    @Override
    protected void cancelacionDePedido(Cancelado estadoCancelado) {
        estadoCancelado.protocoloDeCancelamientoEnviado();
    }

    @Override
    public void cancelarPedido() {
        Cancelado estadoCancelado = new Cancelado();
        estadoCancelado.setPedido(pedido);
        getPedido().cambiarEstado(estadoCancelado);
        estadoCancelado.protocoloDeCancelamiento(this);
    }

    @Override
    public void emailNotificacion(NotificadorEmail  observador) {
        observador.notificionEstadoEnviado();
    }

}
