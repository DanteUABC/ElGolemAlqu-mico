package elgolemalquímico.bus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

// A) LA CLASE EVENT BUS
public class EventBus {
    // Almacena las suscripciones: Tipo de Evento -> Lista de Suscriptores (Funciones)
    private final Map<Class<?>, List<Consumer<?>>> suscriptores = new ConcurrentHashMap<>();

    // Suscribir: Añade un listener para un tipo de evento
    public <T> void suscribir(Class<T> tipoEvento, Consumer<T> suscriptor) {
        suscriptores.computeIfAbsent(tipoEvento, k -> new CopyOnWriteArrayList<>()).add(suscriptor);
    }

    // Desuscribir: Remueve un listener
    public <T> void desuscribir(Class<T> tipoEvento, Consumer<T> suscriptor) {
        List<Consumer<?>> subs = suscriptores.get(tipoEvento);
        if (subs != null) {
            subs.remove(suscriptor);
        }
    }

    // Publicar: Notifica a todos los suscriptores registrados para el evento
    @SuppressWarnings("unchecked")
    public void publicar(Object evento) {
        Class<?> tipo = evento.getClass();
        List<Consumer<?>> subs = suscriptores.get(tipo);
        if (subs != null) {
            for (Consumer<?> sub : subs) {
                // El cast es seguro porque controlamos el ingreso en suscribir()
                ((Consumer<Object>) sub).accept(evento);
            }
        }
    }
}
