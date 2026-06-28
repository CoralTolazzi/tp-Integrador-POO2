package cicloDeVidaDelPedido;

import notificacionesDelPedido.Fidelizacion;

public class Cancelado extends Estado {

    @Override
    public void siguienteEstado() {}

    public void stockearDenuevoProductos(){
        getPedido().getCarrito().forEach(producto -> getPedido().getCatalogo().agregarProducto(producto));
    }

    public void protocoloDeCancelamiento(Estado estadoRecibido){
        estadoRecibido.cancelacionDePedido(this);
    }

    protected void protocoloDeCancelamientoDeConfirmado(){
        stockearDenuevoProductos();
    }

    public void protocoloDeCancelamientoEn_Preparacion() {
        stockearDenuevoProductos();
        //reembolsarCostoTotal();
    }

    public void protocoloDeCancelamientoEnviado() {
        stockearDenuevoProductos();
        //reembolsarCostoProductos();
    }

    public void fidelizacionDelPedido(Fidelizacion fidelizacion) {
        fidelizacion.envioDescuentoFidelizacion();
    }
}

