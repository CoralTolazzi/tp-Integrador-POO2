package metodosDePago;

import cicloDeVidaDelPedido.Pedido;

public class BilleteraVirtual extends MedioDePago {
    BilleteraApi billeteraApi;

    public BilleteraVirtual(BilleteraApi billeteraApi) {
        this.billeteraApi = billeteraApi;
    }

    @Override
    Transaccion validarDatos(Datos datos) {
        return billeteraApi.validarDatos(datos.saldo());
    }

    @Override
    void reservarFondos(Transaccion transaccion, double monto) {
        billeteraApi.reservarFondos(transaccion, monto);
    }

    @Override
    protected void ejecutarTransaccion(Transaccion transaccion) {
        billeteraApi.ejecutarTransaccion(transaccion);
    }

    @Override
    String notificarResultado(Transaccion transaccion) {
        return "Notificación push enviada - Operación nro " + transaccion.nroOperacion();
    }

    @Override
    public void pagoPara(Pedido pedido) {
        Datos datos = new Datos(0,0,null,0,"Alias",5000.0);
        this.pagar(pedido,datos);
    }
}
