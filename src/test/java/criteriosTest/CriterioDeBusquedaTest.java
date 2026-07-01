package criteriosTest;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi_unq_shop.*;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CriterioDeBusquedaTest {
    private Producto productoMock;
    private Catalogo catalogoMock; // <--- Agregado

    @BeforeEach
    void setUp() {
        productoMock = mock(Producto.class);
        catalogoMock = mock(Catalogo.class); // <--- Inicializado como Mock
    }

    @Test
    void testCriterioPorNombre() {
        CriterioPorNombre criterio = new CriterioPorNombre("Notebook");

        // Caso verdadero
        when(productoMock.getNombre()).thenReturn("Notebook Asus Gamer");
        assertTrue(criterio.cumple(productoMock, catalogoMock)); // <--- Se agrega catalogoMock

        // Caso falso
        when(productoMock.getNombre()).thenReturn("Celular Motorola");
        assertFalse(criterio.cumple(productoMock, catalogoMock)); // <--- Se agrega catalogoMock
    }

    @Test
    void testCriterioPorCategoria() {
        CriterioPorCategoria criterio = new CriterioPorCategoria("Electro");

        // Caso verdadero
        when(productoMock.getCategoria()).thenReturn("Electro");
        assertTrue(criterio.cumple(productoMock, catalogoMock));

        // Caso falso
        when(productoMock.getCategoria()).thenReturn("Hogar");
        assertFalse(criterio.cumple(productoMock, catalogoMock));
    }

    @Test
    void testCriterioPorPrecioMaximo() {
        CriterioPorPrecioMaximo criterio = new CriterioPorPrecioMaximo(1500.0);

        // Caso verdadero (menor)
        when(productoMock.getPrecioFinal()).thenReturn(1200.0);
        assertTrue(criterio.cumple(productoMock, catalogoMock));

        // Caso verdadero (límite)
        when(productoMock.getPrecioFinal()).thenReturn(1500.0);
        assertTrue(criterio.cumple(productoMock, catalogoMock));

        // Caso falso (mayor)
        when(productoMock.getPrecioFinal()).thenReturn(1500.1);
        assertFalse(criterio.cumple(productoMock, catalogoMock));
    }

    @Test
    void testCriterioPorDisponibilidad() {
        CriterioPorDisponibilidad criterio = new CriterioPorDisponibilidad(10.0);

        // Caso verdadero (mayor stock)
        when(catalogoMock.verStockDe(productoMock)).thenReturn((int) 15.0);
        assertTrue(criterio.cumple(productoMock, catalogoMock));

        // Caso verdadero (justo en el límite)
        when(catalogoMock.verStockDe(productoMock)).thenReturn((int) 10.0);
        assertTrue(criterio.cumple(productoMock, catalogoMock));

        // Caso falso
        when(catalogoMock.verStockDe(productoMock)).thenReturn((int) 9.9);
        assertFalse(criterio.cumple(productoMock, catalogoMock));
    }

    @Test
    void testCriterioNOT() {
        CriterioDeBusqueda criterioBaseMock = mock(CriterioDeBusqueda.class);
        CriterioNOT criterioNot = new CriterioNOT(criterioBaseMock);

        when(criterioBaseMock.cumple(productoMock, catalogoMock)).thenReturn(true);
        assertFalse(criterioNot.cumple(productoMock, catalogoMock));

        when(criterioBaseMock.cumple(productoMock, catalogoMock)).thenReturn(false);
        assertTrue(criterioNot.cumple(productoMock, catalogoMock));
    }

    @Test
    void testCriterioAND() {
        CriterioDeBusqueda crit1 = mock(CriterioDeBusqueda.class);
        CriterioDeBusqueda crit2 = mock(CriterioDeBusqueda.class);

        CriterioAND criterioAnd = new CriterioAND(Arrays.asList(crit1, crit2));

        when(crit1.cumple(productoMock, catalogoMock)).thenReturn(true);
        when(crit2.cumple(productoMock, catalogoMock)).thenReturn(true);
        assertTrue(criterioAnd.cumple(productoMock, catalogoMock));

        when(crit2.cumple(productoMock, catalogoMock)).thenReturn(false);
        assertFalse(criterioAnd.cumple(productoMock, catalogoMock));
    }

    @Test
    void testCriterioOR() {
        CriterioDeBusqueda crit1 = mock(CriterioDeBusqueda.class);
        CriterioDeBusqueda crit2 = mock(CriterioDeBusqueda.class);

        CriterioOR criterioOr = new CriterioOR(Arrays.asList(crit1, crit2));

        when(crit1.cumple(productoMock, catalogoMock)).thenReturn(false);
        when(crit2.cumple(productoMock, catalogoMock)).thenReturn(false);
        assertFalse(criterioOr.cumple(productoMock, catalogoMock));

        when(crit1.cumple(productoMock, catalogoMock)).thenReturn(true);
        assertTrue(criterioOr.cumple(productoMock, catalogoMock));
    }
}