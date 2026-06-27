package ReporteComponentesTest;

import CatalogoDeProductos.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi_unq_shop.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ReporteComponentesTest {

    private Producto productoA;
    private Producto productoB;
    private ReporteMasVendidos reporte;

    @BeforeEach
    void setUp() {
        productoA = mock(Producto.class);
        productoB = mock(Producto.class);

        when(productoA.getPrecioFinal()).thenReturn(10.0);
        when(productoA.getNombre()).thenReturn("Producto A");
        when(productoA.ventas()).thenReturn(5);
        when(productoA.getCantidadVendida()).thenReturn(5);

        when(productoB.getPrecioFinal()).thenReturn(20.0);
        when(productoB.getNombre()).thenReturn("Producto B");
        when(productoB.ventas()).thenReturn(10);
        when(productoB.getCantidadVendida()).thenReturn(10);

        List<Producto> productos = Arrays.asList(productoA, productoB);
        reporte = new ReporteMasVendidos(productos);
    }

    @Test
    void testReporteMasVendidosYGetted() {
        assertEquals(2, reporte.getProductos().size());

        ReporteVisitor visitorMock = mock(ReporteVisitor.class);
        reporte.aceptar(visitorMock);

        verify(visitorMock, times(1)).visitar(reporte);
    }

    @Test
    void testExportadorCSV() {
        ExportadorCSV exportador = new ExportadorCSV();

        assertEquals("", exportador.getResultado());

        exportador.visitar(reporte);

        String esperado = "Nombre;Cantidad Vendida\n" +
                "Producto A;5\n" +
                "Producto B;10\n";

        assertEquals(esperado, exportador.getResultado());
    }

    @Test
    void testExportadorHtml() {
        ExportadorHtml exportador = new ExportadorHtml();
        assertEquals("", exportador.getResultado());

        exportador.visitar(reporte);

        String esperado = "<h1>Reporte de Ventas</h1>" +
                "<div><p>Nombre: Producto A | Cantidad: 5</p>" +
                "<p>Nombre: Producto B | Cantidad: 10</p></div>";

        assertEquals(esperado, exportador.getResultado());
    }

    @Test
    void testExportadorTxt() {
        ExportadorTxt exportador = new ExportadorTxt();
        assertEquals("", exportador.getResultado());

        exportador.visitar(reporte);

        String esperado = "<h1>Reporte de Ventas</h1>" +
                "<div>Nombre: Producto A | Cantidad: 5\n" +
                "Nombre: Producto B | Cantidad: 10\n</div>";

        assertEquals(esperado, exportador.getResultado());
    }
}
