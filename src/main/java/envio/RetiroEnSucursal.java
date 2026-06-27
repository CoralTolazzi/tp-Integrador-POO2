package envio;

import pedido.Pedido;

public class RetiroEnSucursal implements MetodoDeEnvio {
    @Override
    public double calcularCosto(Pedido pedido) {
        return 0;
    }

    @Override
    public double estimarDias(Pedido pedido) {
        return 0;
    }
}
