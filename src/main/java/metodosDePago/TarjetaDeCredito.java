package metodosDePago;

import cicloDeVidaDelPedido.Pedido;

import java.time.LocalDate;

public class TarjetaDeCredito extends MedioDePago {
    TarjetaApi tarjetaApi;

    public TarjetaDeCredito(TarjetaApi tarjetaApi) {
        this.tarjetaApi = tarjetaApi;
    }

    @Override
    Transaccion validarDatos(Datos datos) {
        return tarjetaApi.validarDatos(datos.nroTarjeta(), datos.CVV(), datos.vencimiento());
    }

    @Override
    void reservarFondos(Transaccion transaccion, double monto) {
        tarjetaApi.reservarFondos(transaccion, monto);
    }

    @Override
    protected void ejecutarTransaccion(Transaccion transaccion) {
        tarjetaApi.ejecutarTransaccion(transaccion);
    }

    @Override
    String notificarResultado(Transaccion transaccion) {
        return "CUPÓN DE PAGO - Operación nro " + transaccion.nroOperacion();
    }

    @Override
    public void pagoPara(Pedido pedido) {
        Datos datos = new Datos(18376287623L,123, LocalDate.now(), 0,"",100000);
        this.pagar(pedido,datos);
    }
}
