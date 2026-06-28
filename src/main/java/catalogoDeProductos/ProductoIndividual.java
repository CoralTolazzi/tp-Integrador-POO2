package catalogoDeProductos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ProductoIndividual extends Producto{
    public String SKU;
    public String marca;
    public String categoria;
    public double precioBase;
    public Map<String,Object> atributosDinamicos;

    public ProductoIndividual(String nombre, String descripcion, double descuento, String SKU, String marca, String categoria, double precioBase){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setSKU(SKU);
        setMarca(marca);
        setCategoria(categoria);
        setPrecioBase(precioBase);
        setAtributosDinamicos(new HashMap<>());
    }

    public ProductoIndividual(String nombre, String descripcion, double descuento, String SKU, String marca, String categoria, double precioBase, double peso){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setSKU(SKU);
        setMarca(marca);
        setCategoria(categoria);
        setPrecioBase(precioBase);
        setAtributosDinamicos(new HashMap<>());
        setPeso(peso);
    }

    public void setPeso(double peso) {
        getAtributosDinamicos().put("peso", peso);
    }

    public void setAtributoDinamico(String atributo, Object valor){
        getAtributosDinamicos().put(atributo,valor);
    }

    //Getters

    public Object getAtributoDinamico(String atributoBuscado){
        return getAtributosDinamicos().get(atributoBuscado);
    }

    @Override
    public double getPrecioFinal() {
        return getPrecioBase() - (getPrecioBase()*getDescuento());
    }

    @Override
    public double getPeso() {
        return (double) getAtributosDinamicos().getOrDefault("peso", 1.0);
    }


}
