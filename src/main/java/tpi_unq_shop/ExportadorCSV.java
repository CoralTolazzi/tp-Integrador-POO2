package tpi_unq_shop;

import catalogoDeProductos.Producto;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ExportadorCSV implements ReporteVisitor{
    private String resultado;

    public ExportadorCSV(){
        this.resultado = "";
    }

    public void visitar(ReporteMasVendidos reporte) {
        List<Producto> productosOrdenados = reporte.productos().stream().sorted(Comparator.comparing(Producto::getPrecioFinal)).toList();

        String cabecera = "Nombre;Cantidad Vendida\n";

        String lineasCsv = productosOrdenados.stream()
                .map(p -> p.getNombre() + ";" + p.getAtributo("ventas") + "\n")
                .collect(Collectors.joining());

        this.resultado = cabecera + lineasCsv;
    }
}
