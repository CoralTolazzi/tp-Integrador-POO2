package envio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void calcularCosto(){
        EnvioEstandar envio = new EnvioEstandar();
        assertEquals(0, envio.calcularCosto(pedido));
    }

    @Test
    void estimarDias(){
        EnvioEstandar envio = new EnvioEstandar();
        assertEquals(5, envio.estimarDias(pedido));
    }
}
