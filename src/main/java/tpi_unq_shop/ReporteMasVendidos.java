package tpi_unq_shop;

import catalogoDeProductos.Producto;

import java.util.List;

public record ReporteMasVendidos(List<Producto> productos) implements Reporte {
    public void aceptar(ReporteVisitor visitor) {
        visitor.visitar(this);
    }
}
