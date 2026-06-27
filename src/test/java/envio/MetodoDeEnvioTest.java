package envio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pedido.Direccion;
import pedido.Pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MetodoDeEnvioTest {
    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = mock(Pedido.class);
    }

    @Test
    void calcularCostoPedidoSinPeso() {
        when(pedido.getPeso()).thenReturn(0.0);
        when(pedido.getDireccionEnvio()).thenReturn(mock(Direccion.class));

        EnvioEstandar envio = new EnvioEstandar();

        assertEquals(0, envio.calcularCosto(pedido));
    }

    @Test
    void calcularCostoPedidoDeCincoKilos() {
        when(pedido.getPeso()).thenReturn(5.0);
        when(pedido.getDireccionEnvio()).thenReturn(mock(Direccion.class));

        EnvioEstandar envio = new EnvioEstandar();

        assertEquals(50, envio.calcularCosto(pedido));
    }

    @Test
    void calcularCostoPedidoMuyPesado() {
        when(pedido.getPeso()).thenReturn(1234.5);
        when(pedido.getDireccionEnvio()).thenReturn(mock(Direccion.class));

        EnvioEstandar envio = new EnvioEstandar();

        assertEquals(12345, envio.calcularCosto(pedido));
    }

    @Test
    void consultaLaDireccionDelPedido() {
        when(pedido.getPeso()).thenReturn(3.0);
        when(pedido.getDireccionEnvio()).thenReturn(mock(Direccion.class));

        EnvioEstandar envio = new EnvioEstandar();

        envio.calcularCosto(pedido);

        verify(pedido).getDireccionEnvio();
    }

    @Test
    void estimarDias(){
        EnvioEstandar envio = new EnvioEstandar();
        assertEquals(5, envio.estimarDias(pedido));
    }

    @Test
    void estimarDiasNoConsultaElPedido() {
        EnvioEstandar envio = new EnvioEstandar();

        assertEquals(5, envio.estimarDias(pedido));

        verifyNoInteractions(pedido);
    }

    // =================== EnvíoExpress ===================
    @Test
    void calculaCostoDeAcuerdoAlPrecioDelPedido() {
        when(pedido.getPrecio()).thenReturn(1000.0);

        EnvioExpress envio = new EnvioExpress();

        assertEquals(100.0, envio.calcularCosto(pedido));

        verify(pedido).getPrecio();
    }

    @Test
    void estimarDiasSiempreEsUno() {
        EnvioExpress envio = new EnvioExpress();

        assertEquals(1, envio.estimarDias(pedido));

        verifyNoInteractions(pedido);
    }

    @Test
    void calcularCostoEsSiempreCero() {
        RetiroEnSucursal envio = new RetiroEnSucursal();

        assertEquals(0, envio.calcularCosto(pedido));
    }
}
