package catalogoDeProductos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {
    ProductoIndividual producto1Test;
    ProductoIndividual producto2Test;
    ProductoIndividual producto3Test;
    Paquete paqueteTest;

    @BeforeEach
    void setup(){
        producto1Test = new ProductoIndividual("Auriculares Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computación",200);
        producto2Test = new ProductoIndividual("Auriculares Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computación",200,2);
        producto3Test = new ProductoIndividual("Auriculares Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computación",200);

        paqueteTest = new Paquete("Combo Auri","Combo Gamer Auri", 0.2, List.of(producto1Test));
    }

    @Test
    public void aUnProductoSeLePuedePedirSuNombre(){
        assertEquals("Auriculares Gamer", producto1Test.getNombre());
        assertEquals("Combo Auri", paqueteTest.getNombre());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuDescripcion(){
        assertEquals("Auriculares Gamer 7.1", producto1Test.getDescripcion());
        assertEquals("Combo Gamer Auri", paqueteTest.getDescripcion());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuDescuento(){
        assertEquals(0.5, producto1Test.getDescuento());
        assertEquals(0.2, paqueteTest.getDescuento());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuPrecioBase(){
        assertEquals(200.0, producto1Test.getPrecioBase());
        assertEquals(200.0, paqueteTest.getPrecioBase());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuPrecioFinal(){
        Paquete paquete2Test = new Paquete("Combo Auri","Combo Gamer Auri", 0.5, List.of(producto1Test, producto2Test, producto3Test));
        assertEquals(100.0, producto1Test.getPrecioFinal());
        assertEquals(300.0, paquete2Test.getPrecioFinal());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuPeso(){
        Paquete paquete2Test = new Paquete("Combo Auri","Combo Gamer Auri", 0.2, List.of(producto1Test, producto2Test, producto3Test));
        assertEquals(2.0, producto2Test.getPeso());
        assertEquals(2.0, paquete2Test.getPeso());
    }
}
