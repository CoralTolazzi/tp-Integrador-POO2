package tpi_unq_shop;

import catalogoDeProductos.Catalogo;

public interface ReporteVisitor {
    void visitar(ReporteMasVendidos reporte, Catalogo c);
}
