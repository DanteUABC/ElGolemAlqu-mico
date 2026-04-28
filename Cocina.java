package elgolemalquímico.componentes;

import java.util.List;
import elgolemalquímico.bus.EventBus;
import elgolemalquímico.eventos.ComidaPreparadaEvent;
import elgolemalquímico.eventos.PedidoRealizadoEvent;
import java.util.concurrent.CompletableFuture;

public class Cocina {
    private final EventBus eventBus;
    private final List<String> MENU_COMIDA = List.of("Hamburguesa", "Alitas", "Costillas");

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.suscribir(PedidoRealizadoEvent.class, this::prepararComida);
    }

    private void prepararComida(PedidoRealizadoEvent evento) {
        for (String item : evento.items()) {
            if (MENU_COMIDA.contains(item)) {
                // Simulamos el tiempo de cocción en paralelo (5 segundos)
                CompletableFuture.runAsync(() -> {
                    try { Thread.sleep(5000); } catch (InterruptedException e) {}
                    eventBus.publicar(new ComidaPreparadaEvent(evento.pedidoId(), item));
                });
            }
        }
    }
}
