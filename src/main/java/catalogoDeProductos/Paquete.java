package catalogoDeProductos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Paquete extends Producto{
    private List<Producto> productos;

    public Paquete(
            String nombre,
            String descripcion,
            double descuento,
            List<Producto> productos){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setProductos(productos);
    }

    public Paquete(
            String nombre,
            String descripcion,
            double descuento){
        setNombre(nombre);
        setDescripcion(descripcion);
        setDescuento(descuento);
        setProductos(new ArrayList<>());
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

    @Override
    public double getPeso() {
        return getProductos().stream().mapToDouble(Producto::getPeso).sum();
    }

    public void agregarProducto(Producto producto){
        productos.addLast(producto);
    }
}