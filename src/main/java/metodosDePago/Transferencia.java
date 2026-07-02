package metodosDePago;

import cicloDeVidaDelPedido.Pedido;

public class Transferencia extends MedioDePago {
    TransferenciaApi transferenciaApi;

    public Transferencia(TransferenciaApi transferenciaApi) {
        this.transferenciaApi = transferenciaApi;
    }

    @Override
    Transaccion validarDatos(Datos datos) {
        return transferenciaApi.validarDatos(datos.CBU(), datos.alias());
    }

    @Override
    void reservarFondos(Transaccion transaccion, double precio) {
        // No aplica: la transferencia es directa, no reserva fondos (ver enunciado)
    }

    @Override
    protected void ejecutarTransaccion(Transaccion transaccion) {
        transferenciaApi.ejecutarTransferencia(transaccion);
    }

    @Override
    String notificarResultado(Transaccion transaccion) {
        return "COMPROBANTE: Operación nro " + transaccion.nroOperacion();
    }

    @Override
    public void pagoPara(Pedido pedido) {
        Datos datos = new Datos(0,0,null,18376287623L,"alias",100000);
        this.pagar(pedido,datos);
    }
}
