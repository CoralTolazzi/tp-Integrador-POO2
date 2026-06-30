package metodosDePago;

import cicloDeVidaDelPedido.Pedido;

public abstract class MedioDePago {
    public final String pagar(Pedido pedido, Datos datos) {
        Transaccion transaccion = validarDatos(datos);
        reservarFondos(transaccion, pedido.getPrecio());
        ejecutarTransaccion(transaccion);
        return notificarResultado(transaccion);
    }

    abstract Transaccion validarDatos(Datos datos);
    abstract void reservarFondos(Transaccion transaccion, double precio);
    abstract void ejecutarTransaccion(Transaccion transaccion);

    String notificarResultado(Transaccion transaccion) {
        return "Transacción registrada: " + transaccion.nroOperacion();
    }
}
