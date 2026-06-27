package CatalogoDeProductos;

import java.util.List;

public class Paquete extends Producto{
    List<Producto> productos;

    public  Paquete(String nombre,String descripcion,double descuento,List<Producto> productos){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setProductos(productos);
    }

    //Setters
    private void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    //Getters
    @Override
    public double getPrecioBase() {
        return getProductos().stream().mapToDouble(Producto::getPrecioBase).sum();
    }

    @Override
    public double getPrecioFinal() {
        double precioBasePaquete = getPrecioBase();
        return precioBasePaquete - (precioBasePaquete * getDescuento());
    }

    private List<Producto> getProductos() {
        return productos;
    }

    @Override
    public double getPeso() {
        return getProductos().stream().mapToDouble(Producto::getPeso).sum();
    }@Override

    public String getCategoria() {
        return "";
    }
}
