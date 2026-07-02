package cicloDeVidaDelPedido;
import envio.Sucursal;

import catalogoDeProductos.Catalogo;
import envio.EnvioEstandar;
import envio.EnvioExpress;
import envio.RetiroEnSucursal;
import metodosDePago.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EstadoTest {
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
    public void alPasarUnPedidoDeConfirmadoACanceladoElStockDelCatalogoSubeYSeLeSumaElObservadorFidelizacion(){
        Catalogo catalogoTest = new Catalogo();
        Pedido pedidoTest = new Pedido(catalogoTest, transferencia, envioEstandar);
        Estado confirmadoTest = new Confirmado(pedidoTest);
        Cancelado canceladoTest = new Cancelado();
        canceladoTest.setPedido(pedidoTest);
        pedidoTest.setEstado(canceladoTest);
        confirmadoTest.cancelacionDePedido(canceladoTest);
    }
}
