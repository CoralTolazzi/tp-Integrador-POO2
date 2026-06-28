package catalogoDeProductos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {

    @Test
    public void aUnProductoSeLePuedePedirSuNombre(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        List<Producto> xs = new ArrayList<>() ;
        xs.add(producto1Test);
        Paquete paqueteTest = new Paquete("Combo Auri","Combo Gamer Auri", 0.2, xs);
        assertEquals("Auris Gamer", producto1Test.getNombre());
        assertEquals("Combo Auri", paqueteTest.getNombre());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuDescripcion(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        List<Producto> xs = new ArrayList<>() ;
        xs.add(producto1Test);
        Paquete paqueteTest = new Paquete("Combo Auri","Combo Gamer Auri", 0.2, xs);
        assertEquals("Auriculares Gamer 7.1", producto1Test.getDescripcion());
        assertEquals("Combo Gamer Auri", paqueteTest.getDescripcion());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuDescuento(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        List<Producto> xs = new ArrayList<>() ;
        xs.add(producto1Test);
        Paquete paqueteTest = new Paquete("Combo Auri","Combo Gamer Auri", 0.2, xs);
        assertEquals(0.5, producto1Test.getDescuento());
        assertEquals(0.2, paqueteTest.getDescuento());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuPrecioBase(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        List<Producto> xs = new ArrayList<>() ;
        xs.add(producto1Test);
        Paquete paqueteTest = new Paquete("Combo Auri","Combo Gamer Auri", 0.2, xs);
        assertEquals(200.0, producto1Test.getPrecioBase());
        assertEquals(200.0, paqueteTest.getPrecioBase());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuPrecioFinal(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        List<Producto> xs = new ArrayList<>() ;
        xs.add(producto1Test);
        Paquete paqueteTest = new Paquete("Combo Auri","Combo Gamer Auri", 0.5, xs);
        assertEquals(100.0, producto1Test.getPrecioFinal());
        assertEquals(100.0, paqueteTest.getPrecioFinal());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuPeso(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200,2);
        ProductoIndividual producto2Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        List<Producto> xs = new ArrayList<>() ;
        xs.add(producto1Test);
        xs.add(producto2Test);
        Paquete paqueteTest = new Paquete("Combo Auri","Combo Gamer Auri", 0.2, xs);
        assertEquals(2.0, producto1Test.getPeso());
        assertEquals(3.0, paqueteTest.getPeso());
    }

}
