package tpi_unq_shop;

import CatalogoDeProductos.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExportadorTxt implements ReporteVisitor{
    private String resultado;

    public ExportadorTxt(){
        this.resultado = "";
    }

    public void visitar(ReporteMasVendidos reporte) {
        List<Producto> productosOrdenadors = reporte.getProductos().stream().sorted(Comparator.comparing(Producto::getPrecioFinal)).toList();

        String productosHtml = productosOrdenadors.stream()
                .map(p -> "Nombre: " + p.getNombre() + " | Cantidad: " + p.ventas() + "\n")
                .collect(Collectors.joining());

        String resultado = "<h1>Reporte de Ventas</h1>" +
                           "<div>" + productosHtml + "</div>";

        this.resultado = resultado;
    }

    public String getResultado(){
        return this.resultado;
    }
}