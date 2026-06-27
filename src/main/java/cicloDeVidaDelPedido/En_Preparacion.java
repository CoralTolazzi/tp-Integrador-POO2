package cicloDeVidaDelPedido;

public class En_Preparacion extends Estado {
    public En_Preparacion(Pedido pedido) {
        super();
    }

    @Override
    public void siguienteEstado() {
        Estado siguienteEstado = new Enviado(getPedido());
        getPedido().cambiarEstado(siguienteEstado);
    }
}
