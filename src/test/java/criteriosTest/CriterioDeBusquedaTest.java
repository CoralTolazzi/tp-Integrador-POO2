package criteriosTest;

import catalogoDeProductos.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi_unq_shop.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CriterioDeBusquedaTest {
    private Producto productoMock;

    @BeforeEach
    void setUp() {
        productoMock = mock(Producto.class);
    }

    @Test
    void testCriterioPorNombre() {
        CriterioPorNombre criterio = new CriterioPorNombre("Notebook");

        // Caso verdadero
        when(productoMock.getNombre()).thenReturn("Notebook Asus Gamer");
        assertTrue(criterio.cumple(productoMock));

        // Caso falso
        when(productoMock.getNombre()).thenReturn("Celular Motorola");
        assertFalse(criterio.cumple(productoMock));
    }

    @Test
    void testCriterioPorCategoria() {
        CriterioPorCategoria criterio = new CriterioPorCategoria("Electro");

        // Caso verdadero
        when(productoMock.getCategoria()).thenReturn("Electro");
        assertTrue(criterio.cumple(productoMock));

        // Caso falso
        when(productoMock.getCategoria()).thenReturn("Hogar");
        assertFalse(criterio.cumple(productoMock));
    }

    @Test
    void testCriterioPorPrecioMaximo() {
        CriterioPorPrecioMaximo criterio = new CriterioPorPrecioMaximo(1500.0);

        // Caso verdadero (menor)
        when(productoMock.getPrecioFinal()).thenReturn(1200.0);
        assertTrue(criterio.cumple(productoMock));

        // Caso verdadero (límite)
        when(productoMock.getPrecioFinal()).thenReturn(1500.0);
        assertTrue(criterio.cumple(productoMock));

        // Caso falso (mayor)
        when(productoMock.getPrecioFinal()).thenReturn(1500.1);
        assertFalse(criterio.cumple(productoMock));
    }

    @Test
    void testCriterioPorDisponibilidad() {
        CriterioPorDisponibilidad criterio = new CriterioPorDisponibilidad(10.0);

        // Caso verdadero (mayor stock)
        when(productoMock.getAtributo("stock")).thenReturn(15.0);
        assertTrue(criterio.cumple(productoMock));

        // Caso verdadero (justo en el límite)
        when(productoMock.getAtributo("stock")).thenReturn(10.0);
        assertTrue(criterio.cumple(productoMock));

        // Caso falso
        when(productoMock.getAtributo("stock")).thenReturn(9.9);
        assertFalse(criterio.cumple(productoMock));
    }

    @Test
    void testCriterioNOT() {
        CriterioDeBusqueda criterioBaseMock = mock(CriterioDeBusqueda.class);
        CriterioNOT criterioNot = new CriterioNOT(criterioBaseMock);

        when(criterioBaseMock.cumple(productoMock)).thenReturn(true);
        assertFalse(criterioNot.cumple(productoMock));

        when(criterioBaseMock.cumple(productoMock)).thenReturn(false);
        assertTrue(criterioNot.cumple(productoMock));
    }

    @Test
    void testCriterioAND() {
        CriterioDeBusqueda crit1 = mock(CriterioDeBusqueda.class);
        CriterioDeBusqueda crit2 = mock(CriterioDeBusqueda.class);

        CriterioAND criterioAnd = new CriterioAND(Arrays.asList(crit1, crit2));

        when(crit1.cumple(productoMock)).thenReturn(true);
        when(crit2.cumple(productoMock)).thenReturn(true);
        assertTrue(criterioAnd.cumple(productoMock));

        when(crit2.cumple(productoMock)).thenReturn(false);
        assertFalse(criterioAnd.cumple(productoMock));
    }

    @Test
    void testCriterioOR() {
        CriterioDeBusqueda crit1 = mock(CriterioDeBusqueda.class);
        CriterioDeBusqueda crit2 = mock(CriterioDeBusqueda.class);

        CriterioOR criterioOr = new CriterioOR(Arrays.asList(crit1, crit2));

        when(crit1.cumple(productoMock)).thenReturn(false);
        when(crit2.cumple(productoMock)).thenReturn(false);
        assertFalse(criterioOr.cumple(productoMock));

        when(crit1.cumple(productoMock)).thenReturn(true);
        assertTrue(criterioOr.cumple(productoMock));
    }
}