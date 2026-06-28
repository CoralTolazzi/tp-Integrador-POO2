package cicloDeVidaDelPedido;

import catalogoDeProductos.Catalogo;
import catalogoDeProductos.Producto;
import lombok.Getter;
import lombok.Setter;
import notificacionesDelPedido.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pedido {
    public Estado estado;
    List<Producto> carrito;
    public Catalogo catalogo;
    public List<ObservadorPedido> observadores;
    public MailSender mail;

    public Pedido(Catalogo catalogo){
        setEstado(new Borrador(this));
        setCarrito(new ArrayList<>());
        setCatalogo(catalogo);
        setObservadores(new ArrayList<>());
        setMail(new MailSenderAUX());
    }

//    Deberia dejarlo? Ummm
//    public Pedido(Estado estado, Catalogo catalogo){
//        setEstado(estado);
//        setCarrito(new ArrayList<>());
//        this.getEstado().setPedido(this);
//        setCatalogo(catalogo);
//    }

    //Operaciones

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
        getEstado().agregarProducto(producto);
    }

    public void agregarProductoAlCarrito(Producto producto) {
        getCarrito().addLast(producto);
    }

    public void quitarProducto(Producto producto) {
        getCarrito().remove(producto);
    }
}