package envio;

import cicloDeVidaDelPedido.Pedido;

public interface MetodoDeEnvio {
    double calcularCosto(Pedido pedido);
    double estimarDias(Pedido pedido);
}
