package cicloDeVidaDelPedido;

public class En_Preparacion extends Estado {
    public En_Preparacion(Pedido pedido) {
        setPedido(pedido);
    }

    @Override
    public void siguienteEstado() {
        Estado siguienteEstado = new Enviado(getPedido());
        getPedido().cambiarEstado(siguienteEstado);
    }

    @Override
    protected void cancelacionDePedido(Cancelado estadoCancelado) {
        estadoCancelado.protocoloDeCancelamientoEn_Preparacion();
    }

    @Override
    public void cancelarPedido() {
        Cancelado estadoCancelado = new Cancelado();
        estadoCancelado.setPedido(pedido);
        getPedido().cambiarEstado(estadoCancelado);
        estadoCancelado.protocoloDeCancelamiento(this);
    }
}
