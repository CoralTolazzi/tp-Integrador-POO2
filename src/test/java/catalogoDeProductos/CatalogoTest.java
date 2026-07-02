package catalogoDeProductos;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogoTest {

    @Test
    public void unCatalogoPuedeMostrarElStockDeUnProducto(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        assertEquals(2,catalogoTest.verStockDe(producto1Test));
    }

    @Test
    public void seLePuedePreguntarAUnCatalogoSiTieneUnProductoDisponible(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        assertTrue(catalogoTest.hayStockDisponible(producto1Test));
    }


    @Test
    public void seLePuedeQuitarUnProductoAUnCatalogo(){
        ProductoIndividual producto1Test;
        producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto1Test);
        catalogoTest.agregarProducto(producto1Test);
        assertEquals(2,catalogoTest.verStockDe(producto1Test) );
        catalogoTest.quitarProducto(producto1Test);
        assertEquals(1,catalogoTest.verStockDe(producto1Test) );
    }

    @Test
    public void noSeLePuedeQuitarUnProductoAUnCatalogoSiNoLoTiene(){
        ProductoIndividual producto2Test;
        producto2Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto2Test);
        catalogoTest.quitarProducto(producto2Test);
        catalogoTest.quitarProducto(producto2Test);
        assertEquals(0,catalogoTest.verStockDe(producto2Test));
    }

    @Test
    public void noSeLePuedeQuitarUnProductoAUnCatalogoSiNoLoTieneEnElCatalogo(){
        ProductoIndividual producto2Test;
        producto2Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.quitarProducto(producto2Test);
        assertEquals(0,catalogoTest.verStockDe(producto2Test));
    }

    @Test
    public void aUnCatalogoSeLePuedePreguntarElStockDeUnProducto(){
        ProductoIndividual producto2Test;
        producto2Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto2Test);
        assertEquals(1,catalogoTest.verStockDe(producto2Test));
    }

    @Test
    public void aUnCatalogoSeLePuedeAgregarLaVentaDeUnProducto(){
        ProductoIndividual producto2Test;
        producto2Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        Catalogo catalogoTest = new Catalogo();
        catalogoTest.agregarProducto(producto2Test);
        catalogoTest.registrarVentaDe(producto2Test);
        assertEquals(1,catalogoTest.verVentasDe(producto2Test));
    }


}

