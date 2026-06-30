package notificacionesDelPedido;

import catalogoDeProductos.Catalogo;
import cicloDeVidaDelPedido.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ObservadorPedidoTest {

    @Test
    public void aUnObservadorSeLeSetearYPuedePedirElPedidoQueObserva(){
        ObservadorPedido notificadorTest = new NotificadorEmail();
        Catalogo catalogoTest = new Catalogo();
        Pedido pedidoTest = new Pedido(catalogoTest);
        notificadorTest.setPedido(pedidoTest);
        assertInstanceOf(Pedido.class, notificadorTest.getPedido());
        MailSenderAUX mail = new MailSenderAUX();
        notificadorTest.setMailSender(mail);
    }
    @Test
    public void aUnObservadorSeLeSetearYPuedePedirElMailSenderQueUsa(){
        ObservadorPedido notificadorTest = new NotificadorEmail();
        Catalogo catalogoTest = new Catalogo();
        Pedido pedidoTest = new Pedido(catalogoTest);
        notificadorTest.setPedido(pedidoTest);
        MailSenderAUX mail = new MailSenderAUX();
        notificadorTest.setMailSender(mail);
        assertInstanceOf(MailSender.class, notificadorTest.getMailSender());
    }

}
