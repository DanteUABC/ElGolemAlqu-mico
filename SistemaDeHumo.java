package elgolemalquímico.componentes;

import elgolemalquímico.bus.EventBus;
import elgolemalquímico.eventos.BandaTocandoEvent;

public class SistemaDeHumo {
    
    public SistemaDeHumo(EventBus eventBus) {
        eventBus.suscribir(BandaTocandoEvent.class, e -> {
            if (e.nombreCancion().equals("Through the Fire and Flames")) {
                System.out.println("💨🔥 [Sistema de Humo] ¡Detectada canción épica! ¡Disparando humo y fuego a máxima potencia!");
            }
        });
    }
}
