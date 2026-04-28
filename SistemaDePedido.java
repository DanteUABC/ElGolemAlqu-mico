package elgolemalquímico.componentes;
import java.util.List;
import elgolemalquímico.bus.EventBus;
import elgolemalquímico.eventos.PedidoRealizadoEvent;

public class SistemaDePedido {
    private final EventBus eventBus;

    public SistemaDePedido(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void recibirPedido(String mesaId, String pedidoId, List<String> items) {
        System.out.println("📝 [Pedidos] Recibiendo pedido " + pedidoId + " de " + mesaId);
        eventBus.publicar(new PedidoRealizadoEvent(mesaId, pedidoId, items));
    }
}
