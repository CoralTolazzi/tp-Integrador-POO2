package catalogoDeProductos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoIndividual extends Producto{
    private String SKU;
    private String marca;
    private double precioBase;

    public ProductoIndividual(
            String nombre,
            String descripcion,
            double descuento,
            String SKU,
            String marca,
            String categoria,
            double precioBase
    ){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setSKU(SKU);
        setMarca(marca);
        setCategoria(categoria);
        setPrecioBase(precioBase);
    }

    public ProductoIndividual(
            String nombre,
            String descripcion,
            double descuento,
            String SKU,
            String marca,
            String categoria,
            double precioBase,
            double peso
    ){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setSKU(SKU);
        setMarca(marca);
        setCategoria(categoria);
        setPrecioBase(precioBase);
        setPeso(peso);
    }

    private void setPeso(double peso) {
        getAtributosDinamicos().put("peso", peso);
    }

    // Getters
    @Override
    public double getPrecioFinal() {
        return getPrecioBase() - (getPrecioBase()*getDescuento());
    }

    @Override
    public double getPeso() {
        return ((Number) getAtributosDinamicos().getOrDefault("peso", 0.0)).doubleValue();
    }
}