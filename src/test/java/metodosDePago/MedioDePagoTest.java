package metodosDePago;

import cicloDeVidaDelPedido.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MedioDePagoTest {
    MedioDePago tarjeta;
    MedioDePago transferencia;
    MedioDePago billetera;

    TarjetaApi tarjetaApi;
    TransferenciaApi transferenciaApi;
    BilleteraApi billeteraApi;

    Pedido pedido;
    Datos datos;
    Transaccion transaccion;

    @BeforeEach
    void setUp() {
        datos = new Datos(18376287623L, 123, LocalDate.now(), 18376287623L, "alias", 5000.0);
        transaccion = new Transaccion(12345L);

        tarjetaApi = mock(TarjetaApi.class);
        transferenciaApi = mock(TransferenciaApi.class);
        billeteraApi = mock(BilleteraApi.class);

        pedido = mock(Pedido.class);
        when(pedido.getPrecio()).thenReturn(100.0);

        when(tarjetaApi.validarDatos(datos.nroTarjeta(), datos.CVV(), datos.vencimiento()))
                .thenReturn(transaccion);
        when(transferenciaApi.validarDatos(datos.CBU(), datos.alias()))
                .thenReturn(transaccion);
        when(billeteraApi.validarDatos(datos.saldo()))
                .thenReturn(transaccion);

        tarjeta = new TarjetaDeCredito(tarjetaApi);
        transferencia = new Transferencia(transferenciaApi);
        billetera = new BilleteraVirtual(billeteraApi);
    }

    @Test
    void tarjetaNotificaConCupon() {
        assertEquals("CUPÓN DE PAGO - Operación nro 12345", tarjeta.pagar(pedido, datos));
    }

    @Test
    void transferenciaNotificaConComprobante() {
        assertEquals("COMPROBANTE: Operación nro 12345", transferencia.pagar(pedido, datos));
    }

    @Test
    void billeteraNotificaConPush() {
        assertEquals("Notificación push enviada - Operación nro 12345", billetera.pagar(pedido, datos));
    }

    @Test
    void unMedioQueNoPersonalizaUsaLaNotificacionPorDefecto() {
        MedioDePago fake = new MedioDePagoFake();
        assertEquals("Transacción registrada: 99", fake.pagar(pedido, datos));
    }

    @Test
    void tarjetaValidaConNroTarjetaCvvYVencimiento() {
        tarjeta.pagar(pedido, datos);
        verify(tarjetaApi).validarDatos(datos.nroTarjeta(), datos.CVV(), datos.vencimiento());
    }

    @Test
    void transferenciaValidaConCbuYAlias() {
        transferencia.pagar(pedido, datos);
        verify(transferenciaApi).validarDatos(datos.CBU(), datos.alias());
    }

    @Test
    void billeteraValidaConElSaldo() {
        billetera.pagar(pedido, datos);
        verify(billeteraApi).validarDatos(datos.saldo());
    }

    @Test
    void tarjetaReservaElPrecioDelPedido() {
        tarjeta.pagar(pedido, datos);
        verify(tarjetaApi).reservarFondos(transaccion, 100.0);
    }

    @Test
    void billeteraBloqueaElPrecioDelPedido() {
        billetera.pagar(pedido, datos);
        verify(billeteraApi).reservarFondos(transaccion, 100.0);
    }

    @Test
    void tarjetaEjecutaLaTransaccionValidada() {
        tarjeta.pagar(pedido, datos);
        verify(tarjetaApi).ejecutarTransaccion(transaccion);
    }

    @Test
    void transferenciaEjecutaLaTransaccionValidada() {
        transferencia.pagar(pedido, datos);
        verify(transferenciaApi).ejecutarTransferencia(transaccion);
    }

    @Test
    void billeteraEjecutaLaTransaccionValidada() {
        billetera.pagar(pedido, datos);
        verify(billeteraApi).ejecutarTransaccion(transaccion);
    }

    @Test
    void tarjetaEjecutaLosPasosEnOrden() {
        tarjeta.pagar(pedido, datos);
        InOrder inOrder = inOrder(tarjetaApi);
        inOrder.verify(tarjetaApi).validarDatos(datos.nroTarjeta(), datos.CVV(), datos.vencimiento());
        inOrder.verify(tarjetaApi).reservarFondos(transaccion, 100.0);
        inOrder.verify(tarjetaApi).ejecutarTransaccion(transaccion);
    }

    @Test
    void billeteraEjecutaLosPasosEnOrden() {
        billetera.pagar(pedido, datos);
        InOrder inOrder = inOrder(billeteraApi);
        inOrder.verify(billeteraApi).validarDatos(datos.saldo());
        inOrder.verify(billeteraApi).reservarFondos(transaccion, 100.0);
        inOrder.verify(billeteraApi).ejecutarTransaccion(transaccion);
    }

    @Test
    void transferenciaValidaYEjecutaPeroNoReservaNada() {
        transferencia.pagar(pedido, datos);
        InOrder inOrder = inOrder(transferenciaApi);
        inOrder.verify(transferenciaApi).validarDatos(datos.CBU(), datos.alias());
        inOrder.verify(transferenciaApi).ejecutarTransferencia(transaccion);
        verifyNoMoreInteractions(transferenciaApi);
    }

    @Test
    void siElPedidoCuesta0SeReserva0() {
        when(pedido.getPrecio()).thenReturn(0.0);
        tarjeta.pagar(pedido, datos);
        verify(tarjetaApi).reservarFondos(transaccion, 0.0);
    }

    static class MedioDePagoFake extends MedioDePago {
        @Override
        protected Transaccion validarDatos(Datos datos) {
            return new Transaccion(99L);
        }

        @Override
        protected void reservarFondos(Transaccion transaccion, double precio) {}

        @Override
        protected void ejecutarTransaccion(Transaccion transaccion) {}

        @Override
        public void pagoPara(Pedido pedido) {}
    }
}