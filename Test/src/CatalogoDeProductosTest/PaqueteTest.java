package CatalogoDeProductosTest;

import CatalogoDeProductos.Paquete;
import CatalogoDeProductos.Producto;
import CatalogoDeProductos.ProductoIndividual;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class PaqueteTest {

    @Test
    public void elPrecioFinalDeUnPaqueteEsLaSumaDelPrecioBaseDeTodoLoQueContengaConSuPropioDescuento(){
        ProductoIndividual producto1Test = new ProductoIndividual("Auris Gamer","Auriculares Gamer 7.1",0.5,"1","Logitech","Computacion",200);
        ProductoIndividual producto2Test = new ProductoIndividual("Mouse Gamer","Mouse Gamer Sensor UltraSpeed",0.25,"2","Logitech","Computacion",100);
        ProductoIndividual producto3Test = new ProductoIndividual("Monitor XD","Monitor Gamer 24 pulgadas",0.1,"3","Asus","Computacion",500);
        ProductoIndividual producto4Test = new ProductoIndividual("Teclado Novak","Teclado Mecánico Switches Red",0.20,"4","Redragon","Computacion",50);
        List<Producto> comboMoniAuri     = new ArrayList<Producto>();
        comboMoniAuri.addLast(producto1Test);
        comboMoniAuri.addLast(producto3Test);
        Paquete paqueteTest1             = new Paquete("Promocion Auri-Moni", "Mirá y Escucha", 0.5, comboMoniAuri);
        List<Producto> promoGamer        = new ArrayList<Producto>();
        promoGamer.addLast(producto2Test);
        promoGamer.addLast(producto4Test);
        promoGamer.addLast(paqueteTest1);
        Paquete paqueteTest2             = new Paquete("Promocion gamer", "Actualizacion para Universitarios", 0.2, promoGamer);
        assertEquals(680.0,paqueteTest2.getPrecioFinal());
    }



}
