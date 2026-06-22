package CicloDeVidaDelPedido;

import CatalogoDeProductos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public Estado estado;
    List<Producto> carrito;

    public Pedido(){
        setEstado(new Borrador(this));
        setCarrito(new ArrayList<Producto>());
    }

    public Pedido(Estado estado){
        setEstado(estado);
        setCarrito(new ArrayList<Producto>());
        getEstado().setPedido(this);
    }

    //Setters

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    //Getters

    public List<Producto> getCarrito() {
        return carrito;
    }

    public Estado getEstado() {
        return estado;
    }

    //Operaciones

    public void cambiarEstado(Estado siguienteEstado) {
        setEstado(siguienteEstado);
    }

    public void siguientePaso(){
        getEstado().siguienteEstado();
    }

    public void cancelarPedido(){
        getEstado().cancelarPedido();
    }

    public void agregarProducto(Producto producto){
        getEstado().agregarProducto(producto);
    }

    public void agregarProductoAlCarrito(Producto producto) {
        getCarrito().addLast(producto);
    }
}
