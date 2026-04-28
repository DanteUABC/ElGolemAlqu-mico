package elgolemalquímico.eventos;
import java.util.List;
/**
 *
 * @author dnt6
 */
public record PedidoRealizadoEvent(String mesaId, String pedidoId, List<String> items) {}
