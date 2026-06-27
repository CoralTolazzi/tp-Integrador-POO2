package tpi_unq_shop;

import CatalogoDeProductos.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExportadorCSV implements ReporteVisitor{
    private String resultado;

    public ExportadorCSV(){
        this.resultado = "";
    }

    public void visitar(ReporteMasVendidos reporte) {
        List<Producto> productosOrdenadors = reporte.getProductos().stream().sorted(Comparator.comparing(Producto::getPrecioFinal)).toList();

        String cabecera = "Nombre;Cantidad Vendida\n";

        String lineasCsv = productosOrdenadors.stream()
                .map(p -> p.getNombre() + ";" + p.ventas() + "\n")
                .collect(Collectors.joining());

        this.resultado = cabecera + lineasCsv;
    }

    public String getResultado(){
        return this.resultado;
    }
}
