package catalogoDeProductos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaqueteTest {
    @Test
    public void elPrecioFinalDeUnPaqueteEsLaSumaDelPrecioBaseDeTodoLoQueContengaConSuPropioDescuento(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auriculares Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computación",200);
        ProductoIndividual producto2Test = new ProductoIndividual("Mouse Gamer","Mouse Gamer Sensor UltraSpeed",0.25,"2","Logitech","Computación",100);
        ProductoIndividual producto3Test = new ProductoIndividual("Monitor XD","Monitor Gamer 24 pulgadas",0.1,"3","Asus","Computación",500);
        ProductoIndividual producto4Test = new ProductoIndividual("Teclado Novak","Teclado Mecánico Switches Red",0.20,"4","Redragon","Computación",50);
        List<Producto> comboMoniAuri     = new ArrayList<>();
        comboMoniAuri.addLast(producto1Test);
        comboMoniAuri.addLast(producto3Test);
        Paquete paqueteTest1             = new Paquete("Promoción Auri-Moni", "Mirá y Escucha", 0.5, comboMoniAuri);
        List<Producto> promoGamer        = new ArrayList<>();
        promoGamer.addLast(producto2Test);
        promoGamer.addLast(producto4Test);
        promoGamer.addLast(paqueteTest1);
        Paquete paqueteTest2             = new Paquete("Promoción gamer", "Actualización para Universitarios", 0.2, promoGamer);
        assertEquals(680.0,paqueteTest2.getPrecioFinal());
    }

    @Test
    public void sePuedeAgregarProductosAUnPaquete(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auriculares Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computación",200);
        Paquete paqueteTest1             = new Paquete("Promoción Auri-Moni", "Mirá y Escucha", 0.5);
        paqueteTest1.agregarProducto(producto1Test);
        assertEquals(1, paqueteTest1.getProductos().size());
    }
}
