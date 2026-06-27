package catalogoDeProductosTest;

import catalogoDeProductos.ProductoIndividual;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoIndividualTest {
    @Test
    public void aUnProductoSeLePuedePedirSuPeso(){
        ProductoIndividual producto1Test = new ProductoIndividual("Play5","Play 5 Slim",0.2,"1","PlayStation","Consolas",100, 2);
        assertEquals(2.0, producto1Test.getPeso());
    }

    @Test
    public void sePuedeAgregarUnAtributoPersonalizado(){
        ProductoIndividual producto1Test = new ProductoIndividual("Play5","Play 5 Slim",0.2,"1","PlayStation","Consolas",100, 2);
        producto1Test.setAtributo("personalizado",5);
        assertEquals(5, producto1Test.getAtributo("personalizado"));
    }
}
