package cicloDeVidaDelPedido;

import catalogoDeProductos.Catalogo;
import org.junit.jupiter.api.Test;



public class EstadoTest {

    @Test
    public void alPasarUnPedidoDeConfirmadoACanceladoElStockDelCatalogoSubeYSeLeSumaElObservadorFidelizacion(){
        Catalogo catalogoTest = new Catalogo();
        Pedido pedidoTest = new Pedido(catalogoTest);
        Estado confirmadoTest = new Confirmado(pedidoTest);
        Cancelado canceladoTest = new Cancelado();
        canceladoTest.setPedido(pedidoTest);
        pedidoTest.setEstado(canceladoTest);
        confirmadoTest.cancelacionDePedido(canceladoTest);
    }
}
