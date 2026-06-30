package metodosDePago;

public interface BilleteraApi {
    Transaccion validarDatos(double saldo);
    void reservarFondos(Transaccion transaccion, double monto);
    void ejecutarTransaccion(Transaccion transaccion);
}
