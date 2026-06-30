package metodosDePago;

import java.time.LocalDate;

public record Datos(
        long nroTarjeta,
        int CVV,
        LocalDate vencimiento,
        long CBU,
        String alias,
        double saldo
) {}
