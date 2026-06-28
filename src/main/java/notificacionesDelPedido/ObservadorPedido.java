package notificacionesDelPedido;

import cicloDeVidaDelPedido.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ObservadorPedido {
    public Pedido pedido;
    public MailSender mailSender;


    public abstract void actualizar();
}
