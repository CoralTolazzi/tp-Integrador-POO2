package cicloDeVidaDelPedido;

public class Cancelado extends Estado {
    @Override
    public void siguienteEstado() {}

    @Override
    public void cancelarPedido() {}


//    protected void protocoloDeCancelamientoDeConfirmado() {
//        List<Producto> stockAIncrementar = getPedido().getCarrito();
//        while(!stockAIncrementar.isEmpty()){
//            gondola.incrementarStockDe(stockAIncrementar.getFirst());
//            stockAIncrementar.removeFirst();
//        }
//    }
}
