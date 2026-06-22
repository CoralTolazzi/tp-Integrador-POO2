package tpi_unq_shop;

import CatalogoDeProductos.Producto;

import java.util.List;

public class ReporteMasVendidos implements Reporte{
    private List<Producto> productos;

    public ReporteMasVendidos(List<Producto> productos){
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void aceptar(ReporteVisitor visitor) {
        visitor.visitar(this);
    }
}
