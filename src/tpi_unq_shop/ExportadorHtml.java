package tpi_unq_shop;

import CatalogoDeProductos.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExportadorHtml implements ReporteVisitor{
    private String resultado;

    public ExportadorHtml(){
        this.resultado = "";
    }

    public void visitar(ReporteMasVendidos reporte) {
        List<Producto> productosOrdenadors = reporte.getProductos().stream().sorted(Comparator.comparing(Producto::getPrecioFinal)).toList();

        String productosHtml = productosOrdenadors.stream()
                .map(p -> "<p>Nombre: " + p.getNombre() + " | Cantidad: " + p.getCantidadVendida() + "</p>")
                .collect(Collectors.joining());

        String resultado = "<h1>Reporte de Ventas</h1>" +
                           "<div>" + productosHtml + "</div>";

        this.resultado = resultado;
    }

    public String getResultado(){
        return this.resultado;
    }
}
