package CicloDeVidaDelPedido;

public class Enviado extends Estado {
    public Enviado(Pedido pedido) {
        super();
    }

    @Override
    public void siguienteEstado() {
        Estado siguienteEstado = new Entregado(getPedido());
        getPedido().cambiarEstado(siguienteEstado);
    }
}
