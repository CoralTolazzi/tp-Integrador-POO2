package cicloDeVidaDelPedido;

public class Confirmado extends Estado {
    public Confirmado(Pedido pedido) {
        setPedido(pedido);
    }

    @Override
    public void siguienteEstado() {
        Estado siguienteEstado = new En_Preparacion(getPedido());
        getPedido().cambiarEstado(siguienteEstado);
    }

//    @Override
//    public void cancelarPedido() {
//        Cancelado estadoCancelado = new Cancelado();
//        getPedido().cambiarEstado(estadoCancelado);
//        estadoCancelado.protocoloDeCancelamientoDeConfirmado();
//    }
}
