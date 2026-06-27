package CatalogoDeProductosTest;

import CatalogoDeProductos.ProductoIndividual;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProductoIndividualTest {

    @Test
    public void aUnProductoSeLePuedePedirSuPeso(){
        ProductoIndividual producto1Test = new ProductoIndividual("Play5","Play 5 Slim",0.2,"1","PlayStation","Consolas",100, 2);
        assertEquals(2.0, producto1Test.getPeso());
    }


}
