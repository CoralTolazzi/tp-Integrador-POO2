package metodosDePago;

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
}
