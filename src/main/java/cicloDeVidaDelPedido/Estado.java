package cicloDeVidaDelPedido;

import catalogoDeProductos.Producto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Estado {
    public Pedido pedido;

    public abstract void siguienteEstado();

    public void cancelarPedido(){
        Estado estadoCancelado = new Cancelado();
        getPedido().cambiarEstado(estadoCancelado);
    }

    public void agregarProducto(Producto producto) {}
}
