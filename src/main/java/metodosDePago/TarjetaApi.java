package metodosDePago;

import java.time.LocalDate;

public interface TarjetaApi {
    Transaccion validarDatos(long nroTarjeta, int cvv, LocalDate vencimiento);
    void reservarFondos(Transaccion transaccion, double monto);
    void ejecutarTransaccion(Transaccion transaccion);
}
