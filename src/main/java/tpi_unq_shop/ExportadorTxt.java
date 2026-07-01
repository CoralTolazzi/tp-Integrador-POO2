package tpi_unq_shop;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ExportadorTxt implements ReporteVisitor{
    private String resultado;

    public ExportadorTxt(){
        this.resultado = "";
    }

    public void visitar(ReporteMasVendidos reporte, Catalogo c) {
        List<Producto> productosOrdenados = reporte.productos().stream().sorted(Comparator.comparing(Producto::getPrecioFinal)).toList();

        String productosHtml = productosOrdenados.stream()
                .map(p -> "Nombre: " + p.getNombre() + " | Cantidad: " + (c.verVentasDe(p)) + "\n")
                .collect(Collectors.joining());

        this.resultado = "<h1>Reporte de Ventas</h1>" +
                           "<div>" + productosHtml + "</div>";
    }
}