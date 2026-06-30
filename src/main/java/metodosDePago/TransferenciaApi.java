package metodosDePago;

public interface TransferenciaApi {
    Transaccion validarDatos(long CBU, String alias);

    void ejecutarTransferencia(Transaccion transaccion);
}
