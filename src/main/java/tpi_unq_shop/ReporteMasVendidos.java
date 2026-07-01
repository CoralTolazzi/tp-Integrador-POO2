package tpi_unq_shop;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;

import java.util.List;

public record ReporteMasVendidos(List<Producto> productos) implements Reporte {
    public void aceptar(ReporteVisitor visitor, Catalogo c) {
        visitor.visitar(this, c);
    }
}
