package envio;

import pedido.Pedido;

public interface MetodoDeEnvio {
    double calcularCosto(Pedido pedido);
    double estimarDias(Pedido pedido);
}
