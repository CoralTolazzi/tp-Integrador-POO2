package tpi_unq_shop;

import catalogoDeProductos.Catalogo;

public interface Reporte {
    void aceptar(ReporteVisitor visitor, Catalogo c);
}
