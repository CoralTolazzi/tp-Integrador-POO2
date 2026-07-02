package notificacionesDelPedido;
import envio.Sucursal;
import catalogoDeProductos.Catalogo;
import cicloDeVidaDelPedido.Pedido;
import envio.EnvioEstandar;
import envio.EnvioExpress;
import envio.RetiroEnSucursal;
import metodosDePago.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ObservadorPedidoTest {
    MedioDePago tarjeta;
    MedioDePago transferencia;
    MedioDePago billetera;

    TarjetaApi tarjetaApi;
    TransferenciaApi transferenciaApi;
    BilleteraApi billeteraApi;

    Datos datos;
    Transaccion transaccion;

    EnvioExpress envioExpress;
    EnvioEstandar envioEstandar;
    RetiroEnSucursal retiroEnSucursal;

    @BeforeEach
    void setUp() {
        envioExpress = new EnvioExpress();
        envioEstandar = new EnvioEstandar();
        retiroEnSucursal = new RetiroEnSucursal(mock(Sucursal.class));
        datos = new Datos(18376287623L, 123, LocalDate.now(), 18376287623L, "alias", 5000.0);
        transaccion = new Transaccion(12345L);

        tarjetaApi = mock(TarjetaApi.class);
        transferenciaApi = mock(TransferenciaApi.class);
        billeteraApi = mock(BilleteraApi.class);


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
    public void aUnObservadorSeLeSetearYPuedePedirElPedidoQueObserva(){
        ObservadorPedido notificadorTest = new NotificadorEmail();
        Catalogo catalogoTest = new Catalogo();
        Pedido pedidoTest = new Pedido(catalogoTest, billetera, envioExpress);
        notificadorTest.setPedido(pedidoTest);
        assertInstanceOf(Pedido.class, notificadorTest.getPedido());
        MailSenderAUX mail = new MailSenderAUX();
        notificadorTest.setMailSender(mail);
    }
    @Test
    public void aUnObservadorSeLeSetearYPuedePedirElMailSenderQueUsa(){
        ObservadorPedido notificadorTest = new NotificadorEmail();
        Catalogo catalogoTest = new Catalogo();
        Pedido pedidoTest = new Pedido(catalogoTest, transferencia, retiroEnSucursal);
        notificadorTest.setPedido(pedidoTest);
        MailSenderAUX mail = new MailSenderAUX();
        notificadorTest.setMailSender(mail);
        assertInstanceOf(MailSender.class, notificadorTest.getMailSender());
    }

}
