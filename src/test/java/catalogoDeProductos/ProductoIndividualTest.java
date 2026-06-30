package catalogoDeProductos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoIndividualTest {

    @Test
    public void aUnProductoSeLePuedePedirSuSKU(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200,2);
        assertEquals("1", producto1Test.getSKU());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuMarca(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200,2);
        assertEquals("Logitech", producto1Test.getMarca());
    }

    @Test
    public void aUnProductoSeLePuedePedirSuCategoria(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200,2);
        assertEquals("Computacion", producto1Test.getCategoria());
    }

    @Test
    public void aUnProductoSinPesoDefinidoPesa0Kilos(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        assertEquals(0, producto1Test.getPeso());
    }

    @Test
    public void aUnProductoSeLePuedeAgregarUnAtributoNuevo(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200,2);
        producto1Test.setAtributo("Alto", 2.0);
        assertEquals(2.0, producto1Test.getAtributo("Alto"));
    }
}
