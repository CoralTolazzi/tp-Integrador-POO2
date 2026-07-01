package cicloDeVidaDelPedido;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;
import catalogoDeProductos.ProductoIndividual;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PedidoTest {

    @Test
    public void aUnPedidoSeLePuedePedirSuEstado(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        assertInstanceOf(Estado.class, pedidoTest.getEstado());
    }

    @Test
    public void aUnPedidoSeLePuedePedirSuCarrito(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        assertInstanceOf(ArrayList.class, pedidoTest.getCarrito());
    }

    @Test
    public void aUnPedidoSeLePuedePedirSuCatalogo(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        assertInstanceOf(Catalogo.class, pedidoTest.getCatalogo());
    }

    @Test
    public void aUnPedidoSeLePuedePedirSusObservadores(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        assertInstanceOf(ArrayList.class, pedidoTest.getObservadores());
    }

    @Test
    public void aUnPedidoSeLePuedeAgregarProductosMientrasEstaEnBorrador(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        assertEquals(1,pedidoTest.getCarrito().size());
    }



    @Test
    public void aUnPedidoNoSeLePuedeAgregarProductosMientrasEstaEnEstadosQueNoSonBorrador(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.siguientePaso();
        pedidoTest.agregarProducto(producto1Test);
        assertEquals(0,pedidoTest.getCarrito().size());
    }

    @Test
    public void aUnPedidoSeLePuedeQuitarProductosMientrasEstaEnBorrador(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.quitarProducto(producto1Test);
        assertEquals(0,pedidoTest.getCarrito().size());
    }

    @Test
    public void alPasarUnPedidoDeBorradorAConfirmadoElStockDelCatalogoBajaYAhoraTieneUnNotificador(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        assertEquals(1,catalogoTest.verStockDe(producto1Test));
        assertInstanceOf(Confirmado.class, pedidoTest.getEstado());
        assertEquals(1,pedidoTest.getObservadores().size());
    }

    @Test
    public void alPasarUnPedidoDeConfirmadoACanceladoElStockDelCatalogoSubeYSeLeSumaElObservadorFidelizacion(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.cancelarPedido();
        assertEquals(2,catalogoTest.verStockDe(producto1Test));
        assertInstanceOf(Cancelado.class, pedidoTest.getEstado());
        assertEquals(2,pedidoTest.getObservadores().size());
    }

    @Test
    public void alPasarUnPedidoDeConfirmadoAEn_Preparacion(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        assertInstanceOf(En_Preparacion.class, pedidoTest.getEstado());
        assertEquals(1,pedidoTest.getObservadores().size());
    }

    @Test
    public void alPasarUnPedidoDeEn_PreparacionACanceladoElStockDelCatalogoSubeYSeLeSumaElObservadorFidelizacion(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.cancelarPedido();
        assertEquals(2,catalogoTest.verStockDe(producto1Test));
        assertInstanceOf(Cancelado.class, pedidoTest.getEstado());
        assertEquals(2,pedidoTest.getObservadores().size());
    }

    @Test
    public void alPasarUnPedidoDeEn_PreparacionAEnviado(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        assertInstanceOf(Enviado.class, pedidoTest.getEstado());
        assertEquals(1,pedidoTest.getObservadores().size());
    }

    @Test
    public void alPasarUnPedidoDeEnviadoACanceladoElStockDelCatalogoSubeYSeLeSumaElObservadorFidelizacion(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.cancelarPedido();
        assertEquals(2,catalogoTest.verStockDe(producto1Test));
        assertInstanceOf(Cancelado.class, pedidoTest.getEstado());
        assertEquals(2,pedidoTest.getObservadores().size());
    }

    @Test
    public void alPasarUnPedidoDeEnviadoAEntregadoSeLeSumaElObservadorDeGeneradorDeFacturaAlPedidoYSeSumanLasVentas(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        assertInstanceOf(Entregado.class, pedidoTest.getEstado());
        assertEquals(2,pedidoTest.getObservadores().size());
        assertEquals(1,catalogoTest.verVentasDe(producto1Test));
    }

    @Test
    public void noSePuedePasarDeUnPedidoEntregadoAUnSiguienteEstado(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        assertInstanceOf(Entregado.class, pedidoTest.getEstado());
        assertEquals(2,pedidoTest.getObservadores().size());
    }

    @Test
    public void noSePuedePasarDeUnPedidoCanceladoAUnSiguienteEstado(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.cancelarPedido();
        pedidoTest.siguientePaso();
        assertInstanceOf(Cancelado.class, pedidoTest.getEstado());
        assertEquals(1,pedidoTest.getObservadores().size());
    }

    @Test
    public void noSePuedeCancelarUnPedidoCancelado(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.cancelarPedido();
        pedidoTest.cancelarPedido();
        assertInstanceOf(Cancelado.class, pedidoTest.getEstado());
    }

    @Test
    public void noSePuedeCancelarUnPedidoEntregado(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        Pedido pedidoTest = new Pedido(catalogoTest);
        pedidoTest.agregarProducto(producto1Test);
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.siguientePaso();
        pedidoTest.cancelarPedido();
        assertInstanceOf(Entregado.class, pedidoTest.getEstado());
    }

    @Test
    void alAgregarUnProductoAlCarritoQuedaEnElCarrito() {
        Catalogo catalogoTest = new Catalogo();
        Pedido pedido = new Pedido(catalogoTest);
        Producto producto = mock(Producto.class);
        when(producto.getPeso()).thenReturn(2.0);



        pedido.agregarProductoAlCarrito(producto);

        assertEquals(2.0, pedido.getPeso());
    }

    @Test
    void alQuitarUnProductoDelCarritoYaNoEsta() {
        Catalogo catalogoTest = new Catalogo();
        Pedido pedido = new Pedido(catalogoTest);
        Producto producto = mock(Producto.class);
        when(producto.getPeso()).thenReturn(2.0);
        pedido.agregarProductoAlCarrito(producto);

        pedido.quitarProducto(producto);

        assertEquals(0.0, pedido.getPeso());
    }






}
