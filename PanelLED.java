package elgolemalquímico.componentes;
import java.util.List;
import elgolemalquímico.bus.EventBus;
import elgolemalquímico.eventos.BandaTocandoEvent;
import elgolemalquímico.eventos.BebidaServidaEvent;
import elgolemalquímico.eventos.ComidaPreparadaEvent;

public class PanelLED {
    public PanelLED(EventBus eventBus) {
        // Suscrito a múltiples eventos para mostrar colores/notificaciones
        eventBus.suscribir(BebidaServidaEvent.class, e -> 
            System.out.println("🟩 [PANEL LED] ¡Nueva bebida servida en la " + e.mesaId() + "! (" + e.bebida() + ")")
        );
        eventBus.suscribir(ComidaPreparadaEvent.class, e -> 
            System.out.println("🟧 [PANEL LED] ¡Comida caliente lista para el pedido " + e.pedidoId() + "! (" + e.plato() + ")")
        );
        eventBus.suscribir(BandaTocandoEvent.class, e -> 
            System.out.println("🟪 [PANEL LED] ¡" + e.nombreBanda() + " está tocando en vivo! 🎵")
        );
    }
}
