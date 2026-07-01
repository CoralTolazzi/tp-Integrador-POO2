package cicloDeVidaDelPedido;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;
import lombok.Getter;
import lombok.Setter;
import notificacionesDelPedido.*;
import envio.Direccion;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pedido {
    private Estado estado;
    private List<Producto> carrito;
    private Catalogo catalogo;
    private List<ObservadorPedido> observadores;
    private MailSender mail;

    public Pedido(Catalogo catalogo){
        setEstado(new Borrador(this));
        setCarrito(new ArrayList<>());
        setCatalogo(catalogo);
        setObservadores(new ArrayList<>());
        setMail(new MailSenderAUX());
    }

    public void cambiarEstado(Estado siguienteEstado) {
        setEstado(siguienteEstado);
    }

    public void siguientePaso(){
        getEstado().siguienteEstado();
        this.notificar();
    }

    public void notificar() {
        observadores.forEach(ObservadorPedido::actualizar);
    }

    public void cancelarPedido(){
        getEstado().cancelarPedido();
        Fidelizacion fidelizacion = new Fidelizacion();
        getObservadores().add(fidelizacion);
        fidelizacion.setPedido(this);
        fidelizacion.setMailSender(mail);
        this.notificar();
    }


    public void agregarProducto(Producto producto){
        this.getEstado().agregarProducto(producto);
    }

    public void agregarProductoAlCarrito(Producto producto) {
        getCarrito().addLast(producto);
    }

    public void quitarProducto(Producto producto) {
        getCarrito().remove(producto);
    }

    public double getPeso() {
        return carrito.stream().mapToDouble(Producto::getPeso).sum();
    }

    public Direccion getDireccionEnvio() {
        return null;
    }

    public double getPrecio() {
        return carrito.stream().mapToDouble(Producto::getPrecioBase).sum();
    }

    public void registrarVentas() {
        carrito.forEach(p-> catalogo.registrarVentaDe(p));
    }
}