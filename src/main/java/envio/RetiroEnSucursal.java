package envio;

import cicloDeVidaDelPedido.Pedido;

public class RetiroEnSucursal implements MetodoDeEnvio {
    private Sucursal sucursal;

    public RetiroEnSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public double calcularCosto(Pedido pedido) {
        return 0;
    }

    @Override
    public double estimarDias(Pedido pedido) {
        if (sucursal.tieneTodo(pedido.getCarrito())) {
            return 0;
        }
        return 3;
    }
}