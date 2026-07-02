package envio;

import catalogoDeProductos.Producto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class SucursalTest {

    @Test
    void unaSucursalTieneTodoSiTieneStockDeCadaProducto() {
        Producto a = mock(Producto.class);
        Producto b = mock(Producto.class);

        Sucursal sucursal = new Sucursal();
        sucursal.agregarStock(a, 5);
        sucursal.agregarStock(b, 2);

        assertTrue(sucursal.tieneTodo(List.of(a, b)));
    }

    @Test
    void unaSucursalNoTieneTodoSiLeFaltaUnProducto() {
        Producto a = mock(Producto.class);
        Producto b = mock(Producto.class);

        Sucursal sucursal = new Sucursal();
        sucursal.agregarStock(a, 5);

        assertFalse(sucursal.tieneTodo(List.of(a, b)));
    }

    @Test
    void siSeAgregaStockDelMismoProductoSeAcumula() {
        Producto a = mock(Producto.class);

        Sucursal sucursal = new Sucursal();
        sucursal.agregarStock(a, 3);
        sucursal.agregarStock(a, 4);

        assertTrue(sucursal.hayStockDe(a));
    }
}