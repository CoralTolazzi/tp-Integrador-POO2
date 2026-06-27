package CatalogoDeProductos;

import java.util.HashMap;

public class ProductoIndividual extends Producto{
    public String SKU;
    public String marca;
    public String categoria;
    public double precioBase;
    public HashMap<String,Object> atributosDinamicos;

    public ProductoIndividual(String nombre, String descripcion, double descuento, String SKU, String marca, String categoria, double precioBase){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setSKU(SKU);
        setMarca(marca);
        setCategoria(categoria);
        setPrecioBase(precioBase);
        setAtributosDinamicos(new HashMap<String, Object>());
    }

    public ProductoIndividual(String nombre, String descripcion, double descuento, String SKU, String marca, String categoria, double precioBase, double peso){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setSKU(SKU);
        setMarca(marca);
        setCategoria(categoria);
        setPrecioBase(precioBase);
        setAtributosDinamicos(new HashMap<String, Object>());
        setPeso(peso);
    }

    private void setPeso(double peso) {
        getAtributosDinamicos().put("peso", peso);
    }

    //Setters

    private void setAtributosDinamicos(HashMap<String, Object> atributosDinamicos) {
        this.atributosDinamicos = atributosDinamicos;
    }

    private void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    private void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    private void setSKU(String sku) {
        SKU = sku;
    }

    //Getters

    @Override
    public double getPrecioBase() {
        return precioBase;
    }

    @Override
    public double getPrecioFinal() {
        return getPrecioBase() - (getPrecioBase()*getDescuento());
    }

    @Override
    public double getPeso() {
        return (double) getAtributosDinamicos().getOrDefault("peso", 1);
    }

    public HashMap<String, Object> getAtributosDinamicos() {
        return atributosDinamicos;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getSKU() {
        return SKU;
    }
}
