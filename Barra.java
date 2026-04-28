package elgolemalquímico.componentes;
import java.util.List;
import elgolemalquímico.bus.EventBus;
import elgolemalquímico.eventos.BebidaServidaEvent;
import elgolemalquímico.eventos.PedidoRealizadoEvent;
import java.util.concurrent.CompletableFuture;

public class Barra {
    private final EventBus eventBus;
    private final List<String> MENU_BEBIDAS = List.of("Cerveza", "Vino", "Hidromiel");

    public Barra(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.suscribir(PedidoRealizadoEvent.class, this::prepararBebidas);
    }

    private void prepararBebidas(PedidoRealizadoEvent evento) {
        for (String item : evento.items()) {
            if (MENU_BEBIDAS.contains(item)) {
                // Simulamos el tiempo de preparación de forma asíncrona (En paralelo)
                CompletableFuture.runAsync(() -> {
                    try { Thread.sleep(2000); } catch (InterruptedException e) {}
                    eventBus.publicar(new BebidaServidaEvent(evento.mesaId(), item));
                });
            }
        }
    }
}
