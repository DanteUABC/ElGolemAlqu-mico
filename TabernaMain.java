import elgolemalquímico.eventos.BandaTocandoEvent;
import java.util.List;

public class TabernaMain {
    public static void main(String[] args) {
        EventBus bus = new EventBus();

        SistemaDePedido pedidos = new SistemaDePedido(bus);
        Barra barra = new Barra(bus);
        Cocina cocina = new Cocina(bus);
        Banda banda = new Banda(bus);
        SistemaDeSonido sonido = new SistemaDeSonido(bus);
        PanelLED panel = new PanelLED(bus);

        bus.suscribir(BandaTocandoEvent.class, e -> {
            if (e.nombreCancion().equals("El Algoritmo del Amor")) {
                System.out.println("💨 [Sistema de Humo] ¡Disparando humo espeso!");
            }
        });

        System.out.println("--- ¡ABRIENDO LAS PUERTAS DEL GÓLEM ALQUÍMICO! ---\n");

        banda.tocarCancion("Los Seguidores de Dijkstra", "El Algoritmo del Amor", 180);

        pedidos.recibirPedido("Mesa 5", "PED-123", List.of("Cerveza", "Hamburguesa"));

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n--- CERRANDO LA TABERNA ---");
    }
}
