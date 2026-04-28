package elgolemalquímico.componentes;
import java.util.List;
import elgolemalquímico.bus.EventBus;
import elgolemalquímico.eventos.BandaTocandoEvent;

public class SistemaDeSonido {
    public SistemaDeSonido(EventBus eventBus) {
        eventBus.suscribir(BandaTocandoEvent.class, e -> 
            System.out.println("🔊 [Sonido] Ajustando ecualizador para: '" + e.nombreCancion() + "'")
        );
    }
}
