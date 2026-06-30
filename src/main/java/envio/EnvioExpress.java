package envio;

import cicloDeVidaDelPedido.Pedido;

public class EnvioExpress implements MetodoDeEnvio {
    @Override
    public double calcularCosto(Pedido pedido) {
        return pedido.getPrecio() * 0.1;
    }

    @Override
    public double estimarDias(Pedido pedido) {
        return 1;
    }
}
