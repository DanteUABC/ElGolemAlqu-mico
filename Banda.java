package elgolemalquímico.componentes;
import java.util.List;
import elgolemalquímico.bus.EventBus;
import elgolemalquímico.eventos.BandaTocandoEvent;

public class Banda {
    private final EventBus eventBus;

    public Banda(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void tocarCancion(String nombreBanda, String nombreCancion, int duracion) {
        // La banda decide tocar una canción y avisa al sistema
        eventBus.publicar(new BandaTocandoEvent(nombreBanda, nombreCancion, duracion));
    }
}
