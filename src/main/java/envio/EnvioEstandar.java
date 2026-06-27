package envio;

import pedido.Pedido;

public class EnvioEstandar implements MetodoDeEnvio {
    @Override
    public double calcularCosto(Pedido pedido) {
        return CorreoArgentina.estimarEnvio(pedido.getPeso(), pedido.getDireccionEnvio());
    }

    @Override
    public double estimarDias(Pedido pedido) {
        return 5;
    }
}
