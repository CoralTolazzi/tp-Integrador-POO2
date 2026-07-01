package reporteComponentesTest;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi_unq_shop.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ReporteComponentesTest {
    private ReporteMasVendidos reporte;
    Catalogo catalogo;

    @BeforeEach
    void setUp() {
        Producto productoA = mock(Producto.class);
        Producto productoB = mock(Producto.class);
        Catalogo catalogo1 = mock(Catalogo.class);

        when(productoA.getPrecioFinal()).thenReturn(10.0);
        when(productoA.getNombre()).thenReturn("Producto A");
        when(catalogo1.verStockDe(productoA)).thenReturn(5);
        when(catalogo1.verVentasDe(productoA)).thenReturn(5);

        when(productoB.getPrecioFinal()).thenReturn(20.0);
        when(productoB.getNombre()).thenReturn("Producto B");
        when(catalogo1.verStockDe(productoB)).thenReturn(10);
        when(catalogo1.verVentasDe(productoB)).thenReturn(10);

        List<Producto> productos = Arrays.asList(productoA, productoB);
        reporte = new ReporteMasVendidos(productos);
        catalogo = catalogo1;
    }

    @Test
    void testReporteMasVendidosYGot() {
        assertEquals(2, reporte.productos().size());

        ReporteVisitor visitorMock = mock(ReporteVisitor.class);
        reporte.aceptar(visitorMock, catalogo);

        verify(visitorMock, times(1)).visitar(reporte, catalogo);
    }

    @Test
    void testExportadorCSV() {
        ExportadorCSV exportador = new ExportadorCSV();

        assertEquals("", exportador.getResultado());

        exportador.visitar(reporte, catalogo);

        String esperado = """
                Nombre;Cantidad Vendida
                Producto A;5
                Producto B;10
                """;

        assertEquals(esperado, exportador.getResultado());
    }

    @Test
    void testExportadorHtml() {
        ExportadorHtml exportador = new ExportadorHtml();
        assertEquals("", exportador.getResultado());

        exportador.visitar(reporte, catalogo);

        String esperado = "<h1>Reporte de Ventas</h1>" +
                "<div><p>Nombre: Producto A | Cantidad: 5</p>" +
                "<p>Nombre: Producto B | Cantidad: 10</p></div>";

        assertEquals(esperado, exportador.getResultado());
    }

    @Test
    void testExportadorTxt() {
        ExportadorTxt exportador = new ExportadorTxt();
        assertEquals("", exportador.getResultado());

        exportador.visitar(reporte,catalogo);

        String esperado = """
                <h1>Reporte de Ventas</h1>\
                <div>Nombre: Producto A | Cantidad: 5
                Nombre: Producto B | Cantidad: 10
                </div>""";

        assertEquals(esperado, exportador.getResultado());
    }
}
