package notificacionesDelPedido;

import catalogoDeProductos.Catalogo;
import cicloDeVidaDelPedido.Pedido;
import org.junit.jupiter.api.Test;


public class NotificadorEmailTest {

    @Test
    public void cuandoUnPedidoPasaDeEstadoBorradorAConfirmadoSeAvisaEsteCambio(){
        Catalogo catalogoTest = new Catalogo();
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.siguientePaso();
    }
}
